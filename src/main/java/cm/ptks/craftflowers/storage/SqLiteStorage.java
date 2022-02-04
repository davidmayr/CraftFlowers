package cm.ptks.craftflowers.storage;

import cm.ptks.craftflowers.flower.FlowerPot;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SqLiteStorage implements FlowerStorage {

    private Connection connection;

    public SqLiteStorage(File file) {
        try {
            if (!file.exists() && !file.createNewFile())
                return;
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + file.getPath());
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS FlowerPots(" +
                                    "uuid VARCHAR NOT NULL," +
                                    "name VARCHAR NOT NULL," +
                                    "data TEXT NOT NULL," +
                                    "createdAt INTEGER NOT NULL," +
                                    "UNIQUE(uuid, name) ON CONFLICT REPLACE)");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SavedFlowerPot> getSavedFlowers(UUID uuid) {
        List<SavedFlowerPot> flowerPots = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FlowerPots WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            JsonParser parser = new JsonParser();
            while (resultSet.next()) {
                SavedFlowerPot savedFlowerPot = new SavedFlowerPot(resultSet.getString("name"),
                        FlowerPot.parsePot(parser.parse(resultSet.getString("data")).getAsJsonObject()),
                        uuid, resultSet.getLong("createdAt"));
                flowerPots.add(savedFlowerPot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flowerPots;
    }

    @Override
    public void saveFlower(String name, UUID player, FlowerPot flowerPot) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FlowerPots(uuid, name, data, createdAt) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, player.toString());
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, flowerPot.serialize().toString());
            preparedStatement.setLong(4, System.currentTimeMillis());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteFlower(String name, UUID player) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FlowerPots WHERE name = ? AND uuid = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, player.toString());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public @Nullable SavedFlowerPot getFlower(String name, UUID player) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM FlowerPots WHERE name = ? AND uuid = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, player.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next())
                return null;

            return new SavedFlowerPot(resultSet.getString("name"),
                    FlowerPot.parsePot(new JsonParser().parse(resultSet.getString("data")).getAsJsonObject()),
                    player, resultSet.getLong("createdAt"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

package ru.lkodos.dao;

import ru.lkodos.dto.FishDto;
import ru.lkodos.entity.Fish;
import ru.lkodos.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FishDao implements Dao<Integer, Fish> {

    private static final FishDao INSTANCE = new FishDao();

    private static final String FIND_ALL_SQL = """
            SELECT *
            FROM fish
            """;

    private FishDao() {

    }

    @Override
    public List<Fish> findAll() {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = ps.executeQuery();
            List<Fish> fishes = new ArrayList<>();
            while (resultSet.next()) {
                fishes.add(buildFish(resultSet));
            }

            return fishes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Fish> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Fish entity) {

    }

    @Override
    public Fish save(Fish entity) {
        return null;
    }

    public static FishDao getInstance() {
        return INSTANCE;
    }

    private Fish buildFish(ResultSet resultSet) throws SQLException {
        return new Fish(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("fish_name", String.class)
        );
    }
}

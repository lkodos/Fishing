package ru.lkodos.service;

import ru.lkodos.dao.FishDao;
import ru.lkodos.dto.FishDto;

import java.util.List;
import java.util.stream.Collectors;

public class FishService {

    private static final FishService INSTANCE = new FishService();

    private final FishDao fishDao = FishDao.getInstance();

    private FishService() {
    }

    public List<FishDto> findAll() {
        return fishDao.findAll().stream()
                .map(fish -> new FishDto(
                        fish.getFishName()
                ))
                .collect(Collectors.toList());
    }

    public static FishService getInstance() {
        return INSTANCE;
    }
}

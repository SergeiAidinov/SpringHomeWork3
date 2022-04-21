package ru.yandex.incoming34.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.repo.CategoryBriefRepo;
import ru.yandex.incoming34.repo.CategoryRepo;

@Service
public class CategoryDao {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    CategoryBriefRepo categoryBriefRepo;




}

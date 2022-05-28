package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.reps.TitleEntity;

public interface ITitleEntityCreator
{
    TitleEntity create(String title);
}

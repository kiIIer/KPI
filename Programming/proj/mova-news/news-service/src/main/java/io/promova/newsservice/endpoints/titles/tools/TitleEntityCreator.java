package io.promova.newsservice.endpoints.titles.tools;

import io.promova.newsservice.reps.TitleEntity;
import org.apache.commons.lang3.RandomStringUtils;

public class TitleEntityCreator implements ITitleEntityCreator
{
    @Override
    public TitleEntity create(String title)
    {
        return new TitleEntity(RandomStringUtils.random(10, true, true), title, System.nanoTime());
    }
}

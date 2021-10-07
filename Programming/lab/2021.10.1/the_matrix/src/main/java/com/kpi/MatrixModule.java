package com.kpi;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MatrixModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IMatrixReader.class).to(MatrixReader.class);
        bind(IMatrixWriter.class).to(MatrixWriter.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T1")).to(MinInMax.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T2")).to(Swapper.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T7")).to(Transposer.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T9")).to(FootballFlawless.class);
    }
}

package com.kpi;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MatrixModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IMatrixReader.class).to(MatrixReader.class);
        bind(IMatrixWriter.class).to(MatrixWriter.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T0")).to(MinInMaxProcessor.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T1")).to(SwapProcessor.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T6")).to(TransposeProcessor.class);
        bind(IMatrixProcessor.class).annotatedWith(Names.named("T8")).to(FootballFlawlessProcessor.class);
    }
}

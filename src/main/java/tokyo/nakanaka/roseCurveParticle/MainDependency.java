package tokyo.nakanaka.roseCurveParticle;

import tokyo.nakanaka.Scheduler;
import tokyo.nakanaka.WorldFinder;

public record MainDependency(Scheduler scheduler, ParticleParseHandler particleParseHandler, WorldFinder worldFinder) {

}

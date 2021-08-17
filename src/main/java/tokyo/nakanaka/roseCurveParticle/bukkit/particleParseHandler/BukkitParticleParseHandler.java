package tokyo.nakanaka.roseCurveParticle.bukkit.particleParseHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.ParticleID;
import tokyo.nakanaka.roseCurveParticle.ParticleParseHandler;
import tokyo.nakanaka.roseCurveParticle.SubParticleParseHandler;

public class BukkitParticleParseHandler implements ParticleParseHandler {
private Map<NamespacedID, SubParticleParseHandler> subParseMap = new HashMap<>();
	
	public BukkitParticleParseHandler() {
		subParseMap.put(NamespacedID.valueOf("minecraft:dust"), new DustParticleHandler());
		subParseMap.put(NamespacedID.valueOf("minecraft:block"), new BlockParticleParseHandler());
		subParseMap.put(NamespacedID.valueOf("minecraft:falling_dust"), new FallingDustParticleParseHandler());
		subParseMap.put(NamespacedID.valueOf("minecraft:item"), new ItemParticleParseHandler());
		subParseMap.put(NamespacedID.valueOf("minecraft:dust_color_transition"), new DustColorTransitionParticleHandler());
	}
	
	@Override
	public Particle onParse(String label, String[] args) {
		if(!label.contains(":")) {
			label = "minecraft:" + label;
		}
		NamespacedID id = NamespacedID.valueOf(label);
		if(!this.subParseMap.containsKey(id)) {
			return new Particle(id);
		}
		return this.subParseMap.get(id).onParse(args);
	}

	@Override
	public List<String> onTabComplete(String label, String[] args) {
		if(args.length == 0) {
			return List.of(ParticleID.values()).stream()
					.map(s -> "minecraft:" + s.toString().toLowerCase())
					.collect(Collectors.toList());
		}else {
			if(!label.contains(":")) {
				label = "minecraft:" + label;
			}
			NamespacedID id;
			try{
				id = NamespacedID.valueOf(label);
			}catch(IllegalArgumentException e) {
				return List.of();
			}
			if(this.subParseMap.containsKey(id)) {
				return this.subParseMap.get(id).onTabComplete(args);
			}else {
				return List.of();
			}
		}
	}

}

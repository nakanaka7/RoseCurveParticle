package tokyo.nakanaka.roseCurveParticle.bukkit.particleParseHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.bukkit.particle.BlockParticleParseHandler;
import tokyo.nakanaka.bukkit.particle.DustParticleParseHandler;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.ParticleID;
import tokyo.nakanaka.particle.SubParticleParseHandler;
import tokyo.nakanaka.roseCurveParticle.ParticleParseHandler;

public class BukkitParticleParseHandler implements ParticleParseHandler {
private Map<NamespacedID, SubParticleParseHandler> subParseMap = new HashMap<>();
	
	public BukkitParticleParseHandler() {
		subParseMap.put(NamespacedID.valueOf("minecraft:dust"), new DustParticleParseHandler());
		subParseMap.put(NamespacedID.valueOf("minecraft:block"), new BlockParticleParseHandler());
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

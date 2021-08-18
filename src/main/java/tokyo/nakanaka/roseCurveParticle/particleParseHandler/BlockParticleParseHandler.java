package tokyo.nakanaka.roseCurveParticle.particleParseHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;

import tokyo.nakanaka.block.Block;
import tokyo.nakanaka.particle.BlockParticle;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.BlockParticle.Type;
import tokyo.nakanaka.roseCurveParticle.SubParticleParseHandler;

public class BlockParticleParseHandler implements SubParticleParseHandler {

	@Override
	public Particle onParse(String[] args) {
		if(args.length != 1) {
			throw new IllegalArgumentException();
		}
		Block block = Block.valueOf(args[0]);
		return new BlockParticle(block, Type.DUST);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		if(args.length == 1) {
			return List.of(Material.values()).stream()
				.filter(s -> s.isBlock())
				.map(s -> "minecraft:" + s.toString().toLowerCase())
				.collect(Collectors.toList());
		}else {
			return List.of();
		}
	}
	
}

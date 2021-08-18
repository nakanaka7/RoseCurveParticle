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
		if(args.length == 0 && 3 <= args.length) {
			throw new IllegalArgumentException();
		}
		Block block = Block.valueOf(args[0]);
		Type type = Type.DUST;
		if(args.length == 2) {
			type = Type.valueOf(args[1].toUpperCase());
		}
		return new BlockParticle(block, type);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		if(args.length == 0) {
			return List.of();
		}else if(args.length == 1) {
			return List.of(Material.values()).stream()
				.filter(s -> s.isBlock())
				.map(s -> "minecraft:" + s.toString().toLowerCase())
				.collect(Collectors.toList());
		}else if(args.length == 2) {
			return List.of(BlockParticle.Type.values()).stream()
					.map(s-> s.toString().toLowerCase())
					.collect(Collectors.toList());
		}else {
			return List.of();
		}
	}
	
}

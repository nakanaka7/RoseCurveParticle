package tokyo.nakanaka.roseCurveParticle.bukkit.particleParseHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;

import tokyo.nakanaka.Item;
import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.particle.ItemParticle;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.roseCurveParticle.SubParticleParseHandler;

public class ItemParticleParseHandler implements SubParticleParseHandler {

	@Override
	public Particle onParse(String[] args) {
		if(args.length != 1) {
			throw new IllegalArgumentException();
		}
		String itemStr = args[0];
		if(!itemStr.contains(":")) {
			itemStr = "minecraft:" + itemStr;
		}
		NamespacedID id = NamespacedID.valueOf(itemStr);
		return new ItemParticle(new Item(id));
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		if(args.length == 1) {
			return List.of(Material.values()).stream()
					.filter(s -> s.isItem())
					.map(s -> "minecraft:" + s.toString().toLowerCase())
					.collect(Collectors.toList());
		}else {
			return List.of();
		}
	}

}

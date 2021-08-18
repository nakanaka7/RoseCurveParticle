package tokyo.nakanaka.roseCurveParticle.commandHandler;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.particleHelp.BlockParticleHelp;
import tokyo.nakanaka.roseCurveParticle.particleHelp.DustColorTransitionParticleHelp;
import tokyo.nakanaka.roseCurveParticle.particleHelp.DustParticleHelp;
import tokyo.nakanaka.roseCurveParticle.particleHelp.FallingDustParticleHelp;
import tokyo.nakanaka.roseCurveParticle.particleHelp.ItemParticleHelp;
import tokyo.nakanaka.roseCurveParticle.particleHelp.ParticleHelp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PtclhelpCommandHandler implements CommandHandler {
    private LinkedHashMap<NamespacedID, ParticleHelp> helpMap = new LinkedHashMap<>();
    public PtclhelpCommandHandler() {
        this.helpMap.put(new NamespacedID("minecraft", "block"), new BlockParticleHelp());
        this.helpMap.put(new NamespacedID("minecraft", "dust"), new DustParticleHelp());
        this.helpMap.put(new NamespacedID("minecraft", "dust_color_transition"), new DustColorTransitionParticleHelp());
        this.helpMap.put(new NamespacedID("minecraft", "falling_dust"), new FallingDustParticleHelp());
        this.helpMap.put(new NamespacedID("minecraft", "item"), new ItemParticleHelp());
    }

    @Override
    public void onCommand(CommandSender cmdSender, String[] args) {
        if(args.length == 0){
            cmdSender.print("--- [" + LogColor.LIGHT_PURPLE + "Quick Help for " + LogColor.RESET + "special particles] ---------------------");
            this.helpMap.entrySet().stream()
                    .map(s -> s.getValue().toSingleLine())
                    .forEach(s -> cmdSender.print(s));
        }else if(args.length == 1) {
            String k = args[0];
            if(!k.contains(":")){
                k = "minecraft:" + k;
            }
            NamespacedID id;
            try{
                id = NamespacedID.valueOf(k);
            }catch(IllegalArgumentException e){
                return;
            }
            if(this.helpMap.containsKey(id)){
                this.helpMap.get(id).toMultipleLines().stream()
                        .forEach(s -> cmdSender.print(s));
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
        if(args.length == 1) {
            return this.helpMap.entrySet().stream()
                    .map(s -> s.getKey().toString())
                    .collect(Collectors.toList());
        }else{
            return List.of();
        }
    }

}

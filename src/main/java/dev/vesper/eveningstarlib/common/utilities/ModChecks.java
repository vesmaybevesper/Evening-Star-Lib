package dev.vesper.eveningstarlib.common.utilities;

import dev.vesper.eveningstarlib.EveningStarLib;
//? !forge{
import net.irisshaders.iris.api.v0.IrisApi;
//?}

public class ModChecks {

	/**
	 * Checks if Iris is present and returns the appropriate boolean; Always returns false on [Lex]Forge
	 * @return boolean
	 */
	public static boolean isIris(){
		//? !forge{
		return EveningStarLib.isModLoaded("iris");
		//?} forge{
		/*return false;
		*///?}
	}

	/**
	 * If Iris is installed it returns a boolean representing if a shader pack is currently enabled, otherwise it returns false
	 * @return boolean
	 */
	// Okay so I need to figure out this check for Optifine or the other shader mod i forget its name
	public static boolean isShaders() {
		//? !forge{
		if (isIris()){
			return IrisApi.getInstance().getConfig().areShadersEnabled();
		} else {
			return false;
		}
		//?} forge {
		/*return false;
		*///?}
	}

	/**
	 * @deprecated
	 * Checks if Sodium is present and returns the appropriate boolean
	 * @return boolean
	 */
	@Deprecated(since = "1.2.1", forRemoval = true)
	public static boolean isSodium(){
		//? !forge{
		return EveningStarLib.isModLoaded("sodium");
		//?} forge{
		/*return false;
		*///?}
	}

	/**
	 * Checks if a Sodium-like mod (Sodium, Embeddium, or Rubidium) is present and returns the appropriate boolean
	 * @return boolean
	 */
	public static boolean isSodiumLike(){
		return  EveningStarLib.isModLoaded("sodium") || EveningStarLib.isModLoaded("embeddium") ||  EveningStarLib.isModLoaded("rubidium");
	}

	/**
	 * Returns a string of which Sodium fork is present
	 * @return String
	 */
	public String sodiumLikeType() {
		if (isSodiumLike()){
			if (EveningStarLib.isModLoaded("sodium")) {
				return "sodium";
			} else if (EveningStarLib.isModLoaded("embeddium")) {
				return "embeddium";
			} else  if (EveningStarLib.isModLoaded("rubidium")) {
				return "rubidium";
			}
		}
		return null;
	}
}

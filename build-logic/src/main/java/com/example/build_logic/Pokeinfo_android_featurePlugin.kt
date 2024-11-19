/**
 * Precompiled [pokeinfo.android.feature.gradle.kts][Pokeinfo_android_feature_gradle] script plugin.
 *
 * @see Pokeinfo_android_feature_gradle
 */
public
class Pokeinfo_android_featurePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Pokeinfo_android_feature_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}

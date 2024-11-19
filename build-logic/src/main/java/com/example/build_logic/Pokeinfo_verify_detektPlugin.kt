/**
 * Precompiled [pokeinfo.verify.detekt.gradle.kts][Pokeinfo_verify_detekt_gradle] script plugin.
 *
 * @see Pokeinfo_verify_detekt_gradle
 */
public
class Pokeinfo_verify_detektPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Pokeinfo_verify_detekt_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}

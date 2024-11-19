/**
 * Precompiled [pokeinfo.android.library.gradle.kts][Pokeinfo_android_library_gradle] script plugin.
 *
 * @see Pokeinfo_android_library_gradle
 */
public
class Pokeinfo_android_libraryPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Pokeinfo_android_library_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}

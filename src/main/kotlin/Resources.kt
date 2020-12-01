import java.io.File
import java.net.URI

// h/t https://github.com/tginsberg/advent-2019-kotlin
internal object Resources {
    fun resourceAsList(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find resource: $this")
}

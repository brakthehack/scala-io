package scalaio.test

import scalax.io.Path
import java.io.{
    FileInputStream, InputStreamReader, BufferedReader
}
object Constants {
    final val TEXT_FILE_SIZE = 21
    final val IMAGE_FILE_SIZE = 6315
    
    final val IMAGE = resource("resources/image.png")
    final val TEXT = resource("resources/text")
    
    final val TEXT_VALUE = {
        val reader = new BufferedReader(new InputStreamReader(TEXT.openStream, "UTF-8"))
        try {
            var line = reader.readLine()
            val value = new StringBuilder()
            while (line!=null) {
                value append line
                value append "\n"
                line = reader.readLine()
            }

            value.toString
        } finally {
            reader.close()
        }
    }
    def resource(resourceName : String) = getClass.getClassLoader.getResource(resourceName)
}
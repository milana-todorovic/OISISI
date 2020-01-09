/**
 * 
 */
package serialization_util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Serializator {

	public static Object deserialize(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(file);

		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
			return ois.readObject();
		}
	}

}

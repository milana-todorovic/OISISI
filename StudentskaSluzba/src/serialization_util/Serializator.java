/**
 * 
 */
package serialization_util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	public static void serialize(String file, Object o) throws FileNotFoundException, IOException {
		File f = new File(file);

		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
			oos.writeObject(o);
		}
	}

}

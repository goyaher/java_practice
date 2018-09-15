package test.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class to do a deep copy of a given object using serialization to an output stream and then de-serialization to an input stream.
 * 
 * @author hgoyal
 *
 */
public class ObjectCopyUtil 
{
	public static Object deepCopy(Object inObject) throws Exception 
	{
		ObjectOutputStream oos = null;
		
		ObjectInputStream ois = null;
		
		try 
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			oos = new ObjectOutputStream(bos);
			
			// serialize and pass the object
			oos.writeObject(inObject); 
			
			oos.flush();
			
			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
			
			ois = new ObjectInputStream(bin);
			
			// return the new object
			return ois.readObject();
		}
		catch (Exception e)
		{
			throw (e);
		} 
		finally 
		{
			oos.close();
			ois.close();
		}
	}
}
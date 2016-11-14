public class Fiveton
{
    private static final Fiveton[] instances = new Fiveton[5];

    private static int index = 0;
 
    private Fiveton() {

    }
 
    // not thread-safe
    public static Fiveton getInstance()
    {
        if (instances[index] == null)
        {
            instances[index] = new Fiveton();
        }
        Fiveton instance = instances[index];
        index = (index + 1) % instances.length;
        return instance;
    }
}

class Demo 
{
    public int i ,j;

    public  Demo fun ()
    {
        this.i = 11;
        return this; // Returns the caller object itself 
    }

    public int gun ()
    {
        return this.i;
    }


}
public class program989 {
    public static void main(String[] args) {

        Demo dobj = new Demo();
        int ret = dobj.fun().gun(); // Dobj.fun() = dobj( becasue of this )
                                    // Dobj.gun() = 11


        System.out.println(ret);

    }
}

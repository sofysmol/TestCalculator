package sofysmo.testCalculator.data;

/**
 * Created by sofysmo on 19.12.16.
 */
public class Identified<PK> {
    protected PK id;
    public PK getId(){
        return id;
    };

    protected Identified(PK id){
        this.id = id;
    }

}

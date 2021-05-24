import java.util.ArrayList;
//https://www.algotree.org/algorithms/recursive/subsets_recursion/
class Superset {

    private int size; // Size of superset.
    private ArrayList<Integer> subset = new ArrayList<Integer> (); 

    Superset ( int s ) { 
        size = s;
    }   

    // Generating subsets / combinations using recursion.
    public void GenerateSubset ( int num ) { 

        if ( num > size ) { 

            System.out.print ( "( " );

            for ( int i = 0; i < subset.size(); i++ ) { 
                System.out.print ( subset.get(i) + " " );
            }

            System.out.println (")");

        } else {

            subset.add (num);
            GenerateSubset ( num + 1 );

            subset.remove ( subset.size() - 1 );
            GenerateSubset ( num + 1 );
        }
    }   

    public int GetSize() {
        return size;
    }   

    public static void main(String[] args) {

        Superset S1 = new Superset(4);
        System.out.println( "All subsets within superset of size : " + S1.GetSize() );
        S1.GenerateSubset(1);


        Superset S2 = new Superset(2);
        System.out.println( "All subsets within superset of size : " + S2.GetSize() );
        S2.GenerateSubset(1);
    }   
}
/*Output

All subsets within superset of size : 4
( 1 2 3 4 )
( 1 2 3 )
( 1 2 4 )
( 1 2 )
( 1 3 4 )
( 1 3 )
( 1 4 )
( 1 )
( 2 3 4 )
( 2 3 )
( 2 4 )
( 2 )
( 3 4 )
( 3 )
( 4 )
( )
All subsets within superset of size : 2
( 1 2 )
( 1 )
( 2 )
( )
*/
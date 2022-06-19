package Work.hello; 
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Kazuate {

    public static int RandomNumber ( int random_max, int random_min )
    {
        Random random = new Random();
        int random_number = random.nextInt(random_max - random_min) + random_min;

        return random_number;
    }

    public static int InputNumber ( int random_max, int random_min )
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("二桁の数字をキーボードから入力してください");
 
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int input_number = Integer.parseInt( input );

        while( input_number < random_min || input_number > random_max )
        {
            System.out.println("もう一度");
            System.out.println("二桁の数字をキーボードから入力してください");
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            input_number = Integer.parseInt( input );
        }

        int return_number = input_number;

        return return_number;
    }

    public static boolean Judge ( int input_number, int random_number, int gap )
    {
        boolean judge = false;
        if( input_number == random_number )
        {
            System.out.println("当たり！");
            judge = true;
        }
        else if( input_number > random_number )
        {
            System.out.println("正解よりも大きいです！");
            if( input_number - random_number >= gap )
            {
                System.out.println("正解と" + gap + "以上の差があります！");
            }
        }
        else
        {
            System.out.println("正解よりも小さいです！");
            if( random_number - input_number >= gap )
            {
                System.out.println("正解と" + gap + "以上の差があります！");
            }
        }
        return judge;
    }

    public static void main (String[] args) 
    {
        int random_min = 10;
        int random_max = 99;
        int random_number = RandomNumber( random_max, random_min );
        System.out.println( random_number );

        boolean flag = false;
        int input_chance = 5;
        int gap = 20;
        for( int i = 0; i < input_chance; i++ )
        {
            int input_number = InputNumber( random_max, random_min );
            flag = Judge( input_number, random_number, gap );
            if( flag )
            {
                System.exit( 1 );
            }
        }
        System.out.println("残念！答えは、" + random_number );
    }
}
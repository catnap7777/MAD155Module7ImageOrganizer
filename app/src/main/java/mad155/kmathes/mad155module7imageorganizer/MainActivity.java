package mad155.kmathes.mad155module7imageorganizer;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Integer[] celebrityPic = {
            R.drawable.cate1,
            R.drawable.jennifer1,
            R.drawable.kate1,
            R.drawable.orlando1,
            R.drawable.tom1,
            R.drawable.will1
            };

    Integer[] cateMovies = {
            R.drawable.cate_elizabeth1,
            R.drawable.cate_elizabeth2,
            R.drawable.cate_lotr_fellowship,
            R.drawable.cate_lotr_king,
            R.drawable.cate_hobbit,
            R.drawable.cate_indiana_skull,
            R.drawable.cate_monuments,
            R.drawable.cate_oceans,
            R.drawable.cate_ragnarok
    };

    Integer[] jenniferMovies = {
            R.drawable.jennifer_apocalypse,
            R.drawable.jennifer_xmen_first,
            R.drawable.jennifer_hunger,
            R.drawable.jennifer_hustle,
            R.drawable.jennifer_joy,
            R.drawable.jennifer_passengers,
            R.drawable.jennifer_silver
    };

    Integer[] kateMovies = {
            R.drawable.kate_chaos,
            R.drawable.kate_divergent,
            R.drawable.kate_dressmaker,
            R.drawable.kate_holiday,
            R.drawable.kate_sense,
            R.drawable.kate_titanic
    };

    Integer[] orlandoMovies = {
            R.drawable.orlando_lotr_fellowship,
            R.drawable.orlando_hobbit,
            R.drawable.orlando_kingdom,
            R.drawable.orlando_musketeers,
            R.drawable.orlando_pirates
    };

    Integer[] tomMovies = {
            R.drawable.tom_big,
            R.drawable.tom_davinci,
            R.drawable.tom_gump,
            R.drawable.tom_sleepless,
            R.drawable.tom_spies,
            R.drawable.tom_terminal,
            R.drawable.tom_toystory
    };

    Integer[] willMovies = {
            R.drawable.will_bright,
            R.drawable.will_hancock,
            R.drawable.will_happiness,
            R.drawable.will_robot,
            R.drawable.will_squad,
            R.drawable.will_mib
    };

    String[] celebrityName = {
            "Cate Blanchett",
            "Jennifer Lawerence",
            "Kate Winslet",
            "Orlando Bloom",
            "Tom Hanks",
            "Will Smith"
            };

    ImageView pic;

    GridView grid2;
    List<Integer> movieList;

    Button btnShowMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.. set the title on the action bar for this activity and override title in manifest
        setTitle(R.string.txtTitle);

        //.. to get rid of action bar for this activity (because I needed more room on screen
        //try
        //{
        //    this.getSupportActionBar().hide();
        //}
        //catch (NullPointerException e){}
        //setContentView(R.layout.activity_main);


        GridView grid1 = (GridView) findViewById(R.id.gridView1);
        grid2 = (GridView) findViewById(R.id.gridView2);

        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        final ImageView pic2 = (ImageView) findViewById(R.id.imgLarge2);
        btnShowMovies = (Button) findViewById(R.id.btn1);
        final TextView celebNameTV = (TextView) findViewById(R.id.txtName);

        btnShowMovies.setOnClickListener(bShowMovies);

        grid1.setAdapter(new ImageAdapter1(this));

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),"Selected Celebrity: " + (position + 1),
                        Toast.LENGTH_SHORT).show();


                pic.setImageResource(celebrityPic[position]);
                celebNameTV.setText(celebrityName[position]);

                switch(position) {
                    case 0:
                        movieList = new ArrayList<>(Arrays.asList(cateMovies));
                        pic2.setImageResource(movieList.get(7));
                        System.out.println("IN THE CATE ARRAY");
                        for(Integer kam: movieList){
                            System.out.println("movie in list: " + kam);
                        }
                        break;
                    case 1:
                        movieList = new ArrayList<>(Arrays.asList(jenniferMovies));
                        pic2.setImageResource(movieList.get(3));
                        System.out.println("IN THE JENNIFER ARRAY");
                        for(Integer kam: movieList){
                            System.out.println("movie in list: " + kam);
                        }
                        break;
                    case 2:
                        movieList = new ArrayList<>(Arrays.asList(kateMovies));
                        break;
                    case 3:
                        movieList = new ArrayList<>(Arrays.asList(orlandoMovies));
                        break;
                    case 4:
                        movieList = new ArrayList<>(Arrays.asList(tomMovies));
                        break;
                    case 5:
                        movieList = new ArrayList<>(Arrays.asList(willMovies));
                        break;
                    default:
                        System.out.println("OOPS!!! BIG PROBLEM");
                        break;
                }

                //grid2.setAdapter(new ImageAdapter2(this));
            }
        });

        if(movieList == null || movieList.isEmpty()){
            System.out.println("MOVIELIST LIST IS EMPTY OR NULL");
        } else {
            grid2.setAdapter(new ImageAdapter2(this));

        }
        //grid2.setAdapter(new ImageAdapter2(this));

    }

    Button.OnClickListener bShowMovies = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            //set up what to pass and perform intent

        }
    };

    public class ImageAdapter1 extends BaseAdapter {

        private Context context;

        public ImageAdapter1(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return celebrityPic.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(celebrityPic[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,375));
            return pic;
        }
    }

    public class ImageAdapter2 extends BaseAdapter {

        private Context context;

        public ImageAdapter2(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            //return movieList.length;
            return movieList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView pic2 = new ImageView(context);
            for (Integer movie: movieList) {
                pic2.setImageResource(movie);
            }
            //pic2.setImageResource(movieList[position]);
            pic2.setScaleType(ImageView.ScaleType.FIT_XY);
            pic2.setLayoutParams(new GridView.LayoutParams(330,375));
            return pic2;
        }
    }
}

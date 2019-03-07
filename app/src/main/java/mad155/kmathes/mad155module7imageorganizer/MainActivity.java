package mad155.kmathes.mad155module7imageorganizer;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
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
import java.util.Collections;
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

    String[] txtCateMovies = {
            "Elizabeth",
            "Elizabeth",
            "Lord of the Rings Fellowship",
            "Lord of the Rings Return of the King",
            "The Hobbit",
            "Indiana Jones and the Crystal Skull",
            "The Monuments Men",
            "Oceans 8",
            "Thor Ragnarok"
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

    String[] txtJenniferMovies = {
            "XMen Apocalypse",
            "XMen First Class",
            "Hunger Games",
            "American Hustle",
            "Joy",
            "Passengers",
            "Silver Linings Playbook"
    };

    Integer[] kateMovies = {
            R.drawable.kate_chaos,
            R.drawable.kate_divergent,
            R.drawable.kate_dressmaker,
            R.drawable.kate_holiday,
            R.drawable.kate_sense,
            R.drawable.kate_titanic
    };

    String[] txtKateMovies = {
            "A Little Chaos",
            "Divergent",
            "The Dressmaker",
            "The Holiday",
            "Sense and Sensibility",
            "Titanic"
    };

    Integer[] orlandoMovies = {
            R.drawable.orlando_lotr_fellowship,
            R.drawable.orlando_hobbit,
            R.drawable.orlando_kingdom,
            R.drawable.orlando_musketeers,
            R.drawable.orlando_pirates
    };

    String[] txtOrlandoMovies = {
            "Lord of the Rings Fellowship",
            "The Hobbit",
            "Last Kingdom",
            "The Three Musketeers",
            "Pirates of the Caribbean"
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

    String[] txtTomMovies = {
            "Big",
            "The DaVinci Code",
            "Forrest Gump",
            "Sleepless in Seattle",
            "Bridge of Spies",
            "The Terminal",
            "Toy Story"
    };

    Integer[] willMovies = {
            R.drawable.will_bright,
            R.drawable.will_hancock,
            R.drawable.will_happiness,
            R.drawable.will_robot,
            R.drawable.will_squad,
            R.drawable.will_mib
    };

    String[] txtWillMovies = {
            "Bright",
            "Hancock",
            "Pursuit of Happiness",
            "I, Robot",
            "Suicide Squad",
            "Men in Black"
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

    List<Integer> movieList;

    String selectedCelebName = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.. set the title on the action bar for this activity and override title in manifest
        setTitle(R.string.txtTitle);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //.. to get rid of action bar for this activity (because I needed more room on screen
        //try
        //{
        //    this.getSupportActionBar().hide();
        //}
        //catch (NullPointerException e){}
        //setContentView(R.layout.activity_main);


        GridView grid1 = (GridView) findViewById(R.id.gridView1);
        final GridView grid2 = (GridView) findViewById(R.id.gridView2);

        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);

        final TextView txtScrollInst2 = (TextView) findViewById(R.id.txtInstructions2);

        final Button buttonImdb = (Button) findViewById(R.id.btnImdb);

        buttonImdb.setOnClickListener(bImdb);

        txtScrollInst2.setVisibility(View.INVISIBLE);
        grid2.setVisibility(View.INVISIBLE);
        buttonImdb.setVisibility(View.INVISIBLE);

        grid1.setAdapter(new ImageAdapter1(this));

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),"Selected Celebrity: " + (position + 1),
                        Toast.LENGTH_SHORT).show();

                pic.setImageResource(celebrityPic[position]);
                selectedCelebName = celebrityName[position];


                txtScrollInst2.setVisibility(View.VISIBLE);
                grid2.setVisibility(View.VISIBLE);
                buttonImdb.setVisibility(View.VISIBLE);

                switch(position) {
                    case 0:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(cateMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnCate));
                        break;
                    case 1:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(jenniferMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnJennifer));
                        break;
                    case 2:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(kateMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnKate));
                        break;
                    case 3:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(orlandoMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnOrlando));
                        break;
                    case 4:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(tomMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnTom));
                        break;
                    case 5:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(willMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnWill));
                        break;
                    default:
                        System.out.println("OOPS!!! BIG PROBLEM");
                        break;
                }


            }
        });

        //..  for testing and initially to have something in movieList otherwise
        //..  I get a null error when I try movieList.clear() in switch stmt
        movieList = new ArrayList<>(Arrays.asList(tomMovies));
        grid2.setAdapter(new ImageAdapter2(this));
        //movieList.clear();
        //movieList = new ArrayList<>(Arrays.asList(willMovies));
        //grid2.setAdapter(new ImageAdapter2(this));

        grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String selectedValue = (String) getListAdapter().getItem(position);
                String selectedValue = " ";


                switch(selectedCelebName) {
                    case "Cate Blanchett":
                        selectedValue = txtCateMovies[position];
                        break;
                    case "Jennifer Lawrence":
                        selectedValue = txtJenniferMovies[position];
                        break;
                    case "Kate Winslett":
                        selectedValue = txtKateMovies[position];
                        break;
                    case "Orlando Bloom":
                        selectedValue = txtOrlandoMovies[position];
                        break;
                    case "Tom Hanks":
                        selectedValue = txtTomMovies[position];
                        break;
                    case "Will Smith":
                        selectedValue = txtWillMovies[position];
                        break;
                    default:
                        break;

                }

                //if(position == 0){
                //    selectedValue = txtCateMovies[position];

                    System.out.println("txtCateMovie = " + selectedValue +
                        " position: " + position);

                    selectedValue = selectedValue.replaceAll("\\s", "+");

                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https")
                            .authority("www.imdb.com")
                            .appendPath("find")
                            .appendQueryParameter("ref_","nv_sr_fn")
                            .appendQueryParameter("q",selectedValue) //from the title parsed and reformatted from the list item selected
                            .appendQueryParameter("s","all");

                    String myUrl = builder.build().toString();

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
                //}
            }
        });

    }

    Button.OnClickListener bImdb = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String celebLookupName = selectedCelebName;

            celebLookupName = celebLookupName.replaceAll("\\s", "+");

            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https")
                    .authority("www.imdb.com")
                    .appendPath("find")
                    .appendQueryParameter("ref_","nv_sr_fn")
                    .appendQueryParameter("q",celebLookupName) //from the title parsed and reformatted from the list item selected
                    .appendQueryParameter("s","all");

            String myUrl = builder.build().toString();

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));

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
            //pic.setLayoutParams(new GridView.LayoutParams(215,265));
            //pic.setLayoutParams(new GridView.LayoutParams(225,275));
            pic.setLayoutParams(new GridView.LayoutParams(300,350));
            return pic;
        }
    }

    public class ImageAdapter2 extends BaseAdapter {

        private Context context;

        public ImageAdapter2(Context con) {
            context = con;
        }

        public ImageAdapter2() {
        }

        @Override
        public int getCount() {
            //return movieList.length; //if this was an array instead and not a List
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
            pic2.setImageResource(movieList.get(position));
            //pic2.setImageResource(movieList[position]); //if it was just an array instead and not a List
            pic2.setScaleType(ImageView.ScaleType.FIT_XY);
            pic2.setLayoutParams(new GridView.LayoutParams(380,445));
            return pic2;
        }
    }
}

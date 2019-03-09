package mad155.kmathes.mad155module7imageorganizer;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
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

    //.. celebrity pictures array for images for GridView1
    Integer[] celebrityPic = {
            R.drawable.cate1,
            R.drawable.jennifer1,
            R.drawable.kate1,
            R.drawable.orlando1,
            R.drawable.tom1,
            R.drawable.will1,
            R.drawable.robert1
    };

    //.. Cate Blanchett movie images for GridView2
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

    //.. Cate Blanchett movie names for IMDB search
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

    //.. Jennifer Lawrence movie images for GridView2
    Integer[] jenniferMovies = {
            R.drawable.jennifer_apocalypse,
            R.drawable.jennifer_xmen_first,
            R.drawable.jennifer_hunger,
            R.drawable.jennifer_hustle,
            R.drawable.jennifer_joy,
            R.drawable.jennifer_passengers,
            R.drawable.jennifer_silver
    };

    //.. Jennifer Lawrence movie names for IMDB search
    String[] txtJenniferMovies = {
            "XMen Apocalypse",
            "XMen First Class",
            "Hunger Games",
            "American Hustle",
            "Joy",
            "Passengers",
            "Silver Linings Playbook"
    };

    //.. Kate Winslet movie images for GridView2
    Integer[] kateMovies = {
            R.drawable.kate_chaos,
            R.drawable.kate_divergent,
            R.drawable.kate_dressmaker,
            R.drawable.kate_holiday,
            R.drawable.kate_sense,
            R.drawable.kate_titanic
    };

    //.. Kate Winslet movie names for IMDB search
    String[] txtKateMovies = {
            "A Little Chaos",
            "Divergent",
            "The Dressmaker",
            "The Holiday",
            "Sense and Sensibility",
            "Titanic"
    };

    //.. Orlando Bloom movie images for GridView2
    Integer[] orlandoMovies = {
            R.drawable.orlando_lotr_fellowship,
            R.drawable.orlando_hobbit,
            R.drawable.orlando_kingdom,
            R.drawable.orlando_musketeers,
            R.drawable.orlando_pirates
    };

    //.. Orlando Bloom movie names for IMDB search
    String[] txtOrlandoMovies = {
            "Lord of the Rings Fellowship",
            "The Hobbit",
            "Last Kingdom",
            "The Three Musketeers",
            "Pirates of the Caribbean"
    };

    //.. Tom Hanks movie images for GridView2
    Integer[] tomMovies = {
            R.drawable.tom_big,
            R.drawable.tom_davinci,
            R.drawable.tom_gump,
            R.drawable.tom_sleepless,
            R.drawable.tom_spies,
            R.drawable.tom_terminal,
            R.drawable.tom_toystory
    };

    //.. Tom Hanks movie names for IMDB search
    String[] txtTomMovies = {
            "Big",
            "The DaVinci Code",
            "Forrest Gump",
            "Sleepless in Seattle",
            "Bridge of Spies",
            "The Terminal",
            "Toy Story"
    };

    //.. Will Smith movie images for GridView2
    Integer[] willMovies = {
            R.drawable.will_bright,
            R.drawable.will_hancock,
            R.drawable.will_happiness,
            R.drawable.will_robot,
            R.drawable.will_squad,
            R.drawable.will_mib
    };

    //.. Will Smith movie names for IMDB search
    String[] txtWillMovies = {
            "Bright",
            "Hancock",
            "Pursuit of Happiness",
            "I, Robot",
            "Suicide Squad",
            "Men in Black"
    };

    //.. Robert Downey Jr. movie images for GridView2
    Integer[] robertMovies = {
            R.drawable.robert_avengers,
            R.drawable.robert_civil_war,
            R.drawable.robert_iron_man,
            R.drawable.robert_only_you,
            R.drawable.robert_sherlock
    };

    //.. Robert Downey Jr. movie names for IMDB search
    String[] txtRobertMovies = {
            "Avengers Infinity War",
            "Captain America Civil War",
            "Iron Man",
            "Only You",
            "Sherlock Holmes"
    };

    //.. Celebrity names for IMDB search
    String[] celebrityName = {
            "Cate Blanchett",
            "Jennifer Lawrence",
            "Kate Winslet",
            "Orlando Bloom",
            "Tom Hanks",
            "Will Smith",
            "Robert Downey Jr."
    };

    ImageView pic;

    List<Integer> movieList;

    String selectedCelebName = " ";

    ConstraintLayout const1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.. set the title on the action bar for this activity and override title in manifest
        setTitle(R.string.txtTitle);

        //.. set logo on action bar
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

        const1 = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        const1.setBackgroundResource(R.drawable.popcorn2);

        GridView grid1 = (GridView) findViewById(R.id.gridView1);
        final GridView grid2 = (GridView) findViewById(R.id.gridView2);

        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);

        final TextView txtScrollInst2 = (TextView) findViewById(R.id.txtInstructions2);

        final Button buttonImdb = (Button) findViewById(R.id.btnImdb);

        buttonImdb.setOnClickListener(bImdb);

        //.. make grid2, scroll instructions, and button invisible until user selects actor/actress
        txtScrollInst2.setVisibility(View.INVISIBLE);
        grid2.setVisibility(View.INVISIBLE);
        buttonImdb.setVisibility(View.INVISIBLE);

        // ??? not sure I know what this does but I was attempting to make scrolling slower
        //grid2.smoothScrollByOffset(int offset)
        //grid2.smoothScrollByOffset(1);
        grid1.smoothScrollToPosition(0);
        grid1.setFriction(ViewConfiguration.getScrollFriction() * 55);
        grid2.setFriction(ViewConfiguration.getScrollFriction() * 55);

        grid1.setAdapter(new ImageAdapter1(this));

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),"Selected Celebrity: " + (position + 1),
                        Toast.LENGTH_SHORT).show();

                pic.setImageResource(celebrityPic[position]);
                selectedCelebName = celebrityName[position];
                //.. set background for constraint layout
                //const1.setBackgroundColor(1);
                //const1.setBackgroundColor(Color.WHITE);
                const1.setBackgroundColor(0xffAEBAC4);

                //.. make grid2, scroll instructions, and button visible again once user selects actor/actress
                txtScrollInst2.setVisibility(View.VISIBLE);
                grid2.setVisibility(View.VISIBLE);
                buttonImdb.setVisibility(View.VISIBLE);

                //.. setup the movies for grid whatever actress/actor was selected
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
                    case 6:
                        movieList.clear();
                        movieList = new ArrayList<>(Arrays.asList(robertMovies));
                        grid2.setAdapter(new ImageAdapter2(getApplicationContext()));
                        buttonImdb.setText(getString(R.string.txtBtnRobert));
                        break;
                    default:
                        System.out.println("OOPS!!! BIG PROBLEM");
                        break;
                }


            }
        });

        //.. for testing and initially to have something in movieList otherwise
        //..  I get a null error when I try movieList.clear() in switch stmt above
        movieList = new ArrayList<>(Arrays.asList(tomMovies));
        grid2.setAdapter(new ImageAdapter2(this));
        //.. for more testing
        //movieList.clear();
        //movieList = new ArrayList<>(Arrays.asList(willMovies));
        //grid2.setAdapter(new ImageAdapter2(this));

        grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String selectedValue = (String) getListAdapter().getItem(position);
                String selectedValue = " ";

                //.. if a movie for an actor/actress is selected, save movie name so that
                //..  an intent can be kicked off to go look it up on IMDB
                switch(selectedCelebName) {
                    case "Cate Blanchett":
                        selectedValue = txtCateMovies[position];
                        break;
                    case "Jennifer Lawrence":
                        selectedValue = txtJenniferMovies[position];
                        break;
                    case "Kate Winslet":
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
                    case "Robert Downey Jr.":
                        selectedValue = txtRobertMovies[position];
                        break;
                    default:
                        break;

                }

                //.. for testing
                //    System.out.println("txtCateMovie = " + selectedValue +
                //        " position: " + position);

                //.. Build URI for intent for looking up movie on IMDB
                    selectedValue = selectedValue.replaceAll("\\s", "+");

                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https")
                            .authority("www.imdb.com")
                            .appendPath("find")
                            .appendQueryParameter("ref_","nv_sr_fn")
                            .appendQueryParameter("q",selectedValue) //from the title parsed and reformatted from the list item selected
                            .appendQueryParameter("s","all");

                    String myUrl = builder.build().toString();
                    //.. Go look up movie
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
                //}
            }
        });

    }

    //.. listener for if user clicks button and want to look up the actual actor/actress on IMDB
    Button.OnClickListener bImdb = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String celebLookupName = selectedCelebName;

            //.. Build URI for intent for looking up actor/actress on IMDB
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

    //.. adapter for grid1
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

    //.. adapter for grid2
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
            pic2.setLayoutParams(new GridView.LayoutParams(375,485));
            return pic2;
        }
    }
}

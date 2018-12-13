package com.example.beverly.horoscope;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    //data container
    ArrayList<Horoscope> list=new ArrayList<Horoscope>();
    //adapter
    CustomAdapter adapter;

    //declare variable for horoscope
    String hor_aries,hor_taurus, hor_gemini, hor_cancer, hor_leo, hor_virgo, hor_libra,
    hor_scorpio, hor_sagittarius, hor_capricorn, hor_aquarius, hor_pisces;

    //declare variable for lucky numbers
    String lnum_aries,lnum_taurus, lnum_gemini, lnum_cancer, lnum_leo, lnum_virgo, lnum_libra,
            lnum_scorpio, lnum_sagittarius, lnum_capricorn, lnum_aquarius, lnum_pisces;

    //set up alert dialog
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set string values for each zodiac sign
        hor_aries = " Maintain an air of detachment, Aries. Feel free to delve into your fantasy world and let your emotions carry you to another realm. Today is one of those days when you might come up with a new invention that could become the next must-have item for every kitchen in the country. Let your imagination take you away. Share your lighthearted mood with others. ";
        hor_taurus = "You may find that things are much lighter than they were the past couple days, Taurus. This is a good time to let your physical body take a rest and let your mind and fantasy world take over. Take a hot bath and soak for a while. Relax your brain and detach from your duties and obligations. Tread lightly and don't worry so much about what you need to do tomorrow. Concentrate on today. ";
        hor_gemini = "A large weight should lift from your shoulders today, Gemini. The air has started to clear and the winds of communication have started blowing again. Listen closely to the buzz in the air. You can learn a lot by tuning into other people's fantasies. Make sure you keep an open mind and open heart. Discuss your latest achievements. You will have something important to learn.";
        hor_cancer = "People may be abrasive today, Cancer, but you will find after careful assessment that they don't mean any harm. More than likely they aren't fully informed. They're acting on misinformation. There's likely to be a cloudy haze in the air. Everyone will have an opinion on the best way to go about tackling an issue. Rely on your own cunning to cut to the core of the problem. ";
        hor_leo = "Don't criticize the situation until you've come up with a better solution, Leo. Be creative. You can accomplish much if you approach the situation confidently. Pessimism won't help find a solution. Relax and let your intuition guide you. Feel free to speak with confidence and strength. Perhaps the most fanciful-sounding answers will be the most ingenious solutions. ";
        hor_virgo = "Your thoughts may have a dreamy quality today, Virgo. You will find that things are less stable than they have been for the past few days. Don't get discouraged by pessimistic people. Offer your own creative solutions. You have a great deal of wisdom to share with others whether you realize it or not. Don't sell yourself short. Have confidence in your thoughts and ideas. ";
        hor_libra = "Your emotions are soaring, Libra, and you should feel free to indulge in your greatest fantasies. Take a break from reality for a while. Let your inner child play. You should enjoy a greater self-confidence that you can use effectively to influence other people. Beware of anyone who asks you to make a solid commitment today. They may not exactly have your well-being in mind. ";
        hor_scorpio = "Reward yourself with two desserts today, Scorpio. Take a bubble bath. Share your fantasies with others and express yourself fully. Don't feel like you have to say yes to every favor that is asked of you. Save some of that nurturing energy for yourself. Feel free to help others in need, but don't do it at the expense of your emotional and physical bank account. ";
        hor_sagittarius = "The weightiness of the past few days seems to be lifting. You will find a slight breeze building that will help fuel your fire, Sagittarius. By building a solid foundation, you've created a reliable launching pad from which to take off. Communicate what you've learned with others. Allow your opinion to be heard. A great deal of useful information will be exchanged. ";
        hor_capricorn = "Now that you have a solid grip on your situation, unexpected things may come along that change the rules again, Capricorn. It may feel like the chair you just got comfortable in has suddenly been pulled out from under you. Don't get angry. Just realize that this is probably a sign that you need to move on. Keep things new and exciting. Share your thoughts and ideas with others. ";
        hor_aquarius = "Use gadgets and electronic devices to make life easier today, Aquarius. Why take the time to chop food by hand when you can use the food processor? Realize that there is most likely an easier way to tackle any task. If something seems too hard, ask for advice how to do the job more quickly and efficiently. Information exchange will play a big role in your day. ";
        hor_pisces = "Be careful of the information that comes your way today, Pisces. People may make unwarranted claims and false accusations. The day has a dreamy, innovative quality to it that asks you to venture out on a limb. If all your chores are taken care of, feel free to go exploring - mentally or physically. Just make sure that you take things with a grain of salt when conversing with others. ";

        //set string values for lucky numbers
        lnum_aries = "3-13-15-20-31-33-46";
        lnum_taurus = "2-8-18-22-26-32-49";
        lnum_gemini = "4-8-16-21-28-34-43";
        lnum_cancer = "4-19-15-21-30-34-45";
        lnum_leo = "3-16-19-23-27-33-47";
        lnum_virgo = "4-15-14-23-28-34-43";
        lnum_libra = "4-12-15-24-28-34-43";
        lnum_scorpio = "3-15-19-24-29-33-48";
        lnum_sagittarius = "6-13-19-21-29-36-44";
        lnum_capricorn = "5-13-16-20-28-35-43";
        lnum_aquarius = "17-32-51-18-37-6";
        lnum_pisces = "2-8-18-23-30-32-45";

        //instantiate
        lv=(ListView)this.findViewById(R.id.listview);
        adapter=new CustomAdapter(this,list);

        //populate the list
        list.add(new Horoscope(R.drawable.aries,"ARIES","Mar 21 - Apr 19"));
        list.add(new Horoscope(R.drawable.taurus,"TAURUS","Apr 20 - May 20"));
        list.add(new Horoscope(R.drawable.gemini,"GEMINI","May 21 - June 20"));
        list.add(new Horoscope(R.drawable.cancer,"CANCER","Jun 21 - Jul 22"));
        list.add(new Horoscope(R.drawable.leo,"LEO","Jul 23 - Aug 22"));
        list.add(new Horoscope(R.drawable.virgo,"VIRGO","Aug 23 - Sep 22"));
        list.add(new Horoscope(R.drawable.libra,"LIBRA","Sep 23 - Oct 22"));
        list.add(new Horoscope(R.drawable.scorpio,"SCORPIO","Oct 23 - Nov 21"));
        list.add(new Horoscope(R.drawable.sagittarius,"SAGGITARIUS","Nov 22 - Dec 21"));
        list.add(new Horoscope(R.drawable.capricorn,"CAPRICORN","Dec 22 - Jan 19"));
        list.add(new Horoscope(R.drawable.aquarius,"AQUARIUS","Jan 20 - Feb 18"));
        list.add(new Horoscope(R.drawable.pisces,"PISCES","Feb 19 - Mar 20"));

        //delegate the adapter
        lv.setAdapter(adapter);
        builder=new AlertDialog.Builder(this);
        builder.setNeutralButton("OKAY", null);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Horoscope selectedHoroscope=this.list.get(position);

        int image=selectedHoroscope.getImg();
        String name=selectedHoroscope.getName();
        String date=selectedHoroscope.getDate();
        ImageView iv=new ImageView(this);
        iv.setImageResource(image);

        ///
        builder.setTitle(""+name);
        builder.setView(iv);

        switch(position){
            case 0:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_aries+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_aries));
                break;
            case 1:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_taurus+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_taurus));
                break;
            case 2:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_gemini+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_gemini));
                break;
            case 3:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_cancer+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_cancer));
                break;
            case 4:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_leo+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_leo));
                break;
            case 5:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_virgo+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_virgo));
                break;
            case 6:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_libra+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_libra));
                break;
            case 7:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_scorpio+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_scorpio));
                break;
            case 8:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_sagittarius+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_sagittarius));
                break;
            case 9:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_capricorn+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_capricorn));
                break;
            case 10:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_aquarius+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_aquarius));
                break;
            case 11:
                builder.setMessage(Html.fromHtml(date.toString()+"<br><br>"+hor_pisces+"<b><br><br>"+"Lucky numbers: "+"</b>"+lnum_pisces));
                break;
        }
        //display the dialog
        AlertDialog dialog=builder.create();
        dialog.show();


        //make the messageview show at the center of the dialog box
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        messageView.setTextColor(Color.parseColor("#aa4b6b"));
    }
}

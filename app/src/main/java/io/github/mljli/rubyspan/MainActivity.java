package io.github.mljli.rubyspan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String sampleText = "<p><span class='colorL'>カンボジア</span>の<ruby>経済<rt>けいざい</rt></ruby>は、<ruby>去年<rt>きょねん</rt></ruby>までの５<ruby>年<rt>ねん</rt></ruby>、７％<ruby>以上<rt>いじょう</rt></ruby>の<a href='javascript:void(0)' class='dicWin' id='id-0001'><ruby><span class=\"under\">成長</span><rt>せいちょう</rt></ruby></a>を<ruby>続<rt>つづ</rt></ruby>けていて、<span class='colorL'><ruby>日本<rt>にっぽん</rt></ruby></span>の<ruby>会社<rt>かいしゃ</rt></ruby>が<ruby>毎年<rt>まいとし</rt></ruby>２００ぐらい<ruby>増<rt>ふ</rt></ruby>えています。<span class='colorL'>プノンペン</span>では<ruby>日本料理<rt>にほんりょうり</rt></ruby>のレストランも<ruby>増<rt>ふ</rt></ruby>えています。<span class='colorL'><ruby>日本<rt>にっぽん</rt></ruby></span>と<span class='colorL'>カンボジア</span>の<ruby>間<rt>あいだ</rt></ruby>を<ruby>飛<rt>と</rt></ruby>ぶ<ruby>飛行機<rt>ひこうき</rt></ruby>で、<span class='colorL'><ruby>日本<rt>にっぽん</rt></ruby></span>から<ruby>野菜<rt>やさい</rt></ruby>や<ruby>肉<rt>にく</rt></ruby>などを<ruby>運<rt>はこ</rt></ruby>びやすくなると<ruby>考<rt>かんが</rt></ruby>えられています。</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textview);
        textView.setTextSize(28);
        // IMPORTANT!
        textView.setLineSpacing(0, 1.5f);
        float textSize = textView.getTextSize();
        textView.setPadding(0, (int)(textSize/2 + 5), 0, 0);

        SpannableStringBuilder ssb = new SpannableStringBuilder("東京へ行きたい");
        ssb.setSpan(new RubySpan("とうきょう"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new RubySpan("い"), 3, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ssb);



        TextView textView2 = (TextView)findViewById(R.id.textview2);
        textView2.setTextSize(28);
        // IMPORTANT!
        textView2.setLineSpacing(0, 1.5f);
        textView2.setPadding(0, (int)(textSize/2 + 5), 0, 0);

        ssb = new SpannableStringBuilder("あ飛行機車あ");
        ssb.setSpan(new RubySpan("ひこうき"), 1, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new RubySpan("くるま"), 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView2.setText(ssb);



        TextView textView3 = (TextView)findViewById(R.id.textview3);
        textView3.setTextSize(20);
        // IMPORTANT!
        textView3.setLineSpacing(0, 1.5f);
        textSize = textView3.getTextSize();
        textView3.setPadding(0, (int)(textSize/2 + 5), 0, 0);
        textView3.setText(Html.fromHtml(sampleText, null, new RubyTagHandler()));
    }
}

package uk.co.taniakolesnik.rememberall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.button_magic)
    Button magic_btn;

    @Override
    public void onBackPressed() {
        if (magic_btn.getText().equals(getString(R.string.magic_button_text))) {
            restore();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            restore();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void restore() {
        magic_btn.setText(getString(R.string.button_name));
        textView.setText(getString(R.string.app_name));
        textView.setTextColor(getColor(R.color.primaryTextColor));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        magic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeMagic();
            }
        });
    }

    private void doSomeMagic() {
        magic_btn.setText(getString(R.string.magic_button_text));
        textView.setText(getString(R.string.magic_text));
        textView.setTextColor(getColor(R.color.secondaryDarkColor));
        YoYo.with(Techniques.ZoomInUp)
                .delay(0)
                .repeat(0)
                .playOn(textView);
    }
}

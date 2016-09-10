package id.sch.smktelkom_mlg.tugas01.xirpl224.formpengembalianbukupustel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etBuku;
    Button bOk;
    TextView tvHasil;
    RadioGroup rgStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etBuku = (EditText) findViewById(R.id.editTextBuku);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String buku = etBuku.getText().toString();
            tvHasil.setText("Nama : " + nama + "Judul Buku : " + buku);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String buku = etBuku.getText().toString();
        String hasil = null;

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
            valid = false;
        } else if (buku.isEmpty()) {
            etBuku.setError(" Judul Buku Belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == null) {
            tvHasil.setText("Belum Memilih Status");
        } else {
            tvHasil.setText("Jurusan Anda : " + hasil);
        }

        return valid;
    }
}

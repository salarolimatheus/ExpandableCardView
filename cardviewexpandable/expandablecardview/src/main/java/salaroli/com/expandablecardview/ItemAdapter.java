package salaroli.com.expandablecardview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ItemAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}

//public class AlunosAdapter extends BaseAdapter {
//    private final List<Aluno> alunos;
//    private final Context context;
//
//    public AlunosAdapter(Context context, List<Aluno> alunos) {
//        this.context = context;
//        this.alunos = alunos;
//    }
//
//    @Override
//    public int getCount() {
//        return alunos.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return alunos.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return alunos.get(position).getId();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Aluno aluno = alunos.get(position);
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = convertView;
//        if (view == null) {
//
//            view = inflater.inflate(R.layout.list_item, parent, false);
//        }
//
//        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
//        campoNome.setText(aluno.getNome());
//
//        TextView campoTelefone = (TextView) view.findViewById(R.id.item_telefone);
//        campoTelefone.setText(aluno.getTelefone());
//
//        TextView campoEndereco = (TextView) view.findViewById(R.id.item_endereco);
//        if (campoEndereco != null) {
//            campoEndereco.setText(aluno.getEndereco());
//        }
//
//        TextView campoSite = view.findViewById(R.id.item_site);
//        if (campoSite != null) {
//            campoSite.setText(aluno.getSite());
//        }
//
//        ImageView campoFoto = (ImageView) view.findViewById(R.id.item_foto);
//        String caminhoFoto = aluno.getCaminhoFoto();
//
//
//        if (caminhoFoto != null) {
//            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
//            Bitmap bitmap_reduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
//            campoFoto.setImageBitmap(bitmap_reduzido);
//            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
//
//        return view;
//    }
//}
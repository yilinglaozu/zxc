package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.myshujuku.R;

import java.util.List;

import bean.UserBean;

public class MyBase extends BaseAdapter {
    private List<UserBean> list;
    private Context context;

    public MyBase(List<UserBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
       ViewHolder holder;
       if (convertView==null){
           convertView=View.inflate(context,R.layout.zibuju,null);
           holder=new ViewHolder();
           holder.zi_text=convertView.findViewById(R.id.zi_text);
           holder.zi_text2=convertView.findViewById(R.id.zi_text2);
           convertView.setTag(holder);

       }else{
           holder= (ViewHolder) convertView.getTag();

       }
       holder.zi_text.setText(list.get(position).getName());
       holder.zi_text2.setText(list.get(position).getPass());
        return convertView;
    }
    class ViewHolder{
        TextView zi_text,zi_text2;

    }
}

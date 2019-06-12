package cn.edu.hebtu.software.peaceuser;

import android.util.Log;

import java.net.URI;

public class UserInfoModel {
    /**
     * 获取用户详细信息
     *
     */
    public User getUserInfo(int userID) throws Exception
    {
        User user = null;
        HttpClient httpclient = new DefaultHttpClient();
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        //qparams.add(new BasicNameValuePair("method", "getDetail"));
        qparams.add(new BasicNameValuePair("id",String.valueOf(userID)));
        URI uri = URIUtils.createURI("http", ServerConfiguration.IP,
                ServerConfiguration.PORT,
                ServerConfiguration.USERSERVICEURI,
                URLEncodedUtils.format(qparams, "UTF-8"), null);
        Log.i("ju", "uri:"+uri.toString());
        HttpGet httpget = new HttpGet(uri);
        //HttpPost httpget=new HttpPost(uri);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        JSONObject o = null;
        if (entity != null)
        {
            String contentString = EntityUtils.toString(entity);
            Log.i("ju", contentString);
            o = new JSONObject(contentString);
            int status =o.getInt("status");
            Log.i("ju","status:"+ status);

            if (status != 1)
            {
                Log.i("ju","status:"+ status);
                return user;
            }

            JSONObject e = o.getJSONObject("user");
            user = new User();

            user.setUserID(e.getInt("id"));
            user.setUserName(e.getString("userName"));
            user.setPassword(e.getString("password"));
        }

        httpclient.getConnectionManager().shutdown();
        return user;
    }
}

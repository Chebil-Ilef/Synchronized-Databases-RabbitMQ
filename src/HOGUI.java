import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class HOGUI {
    public final String HO_DBNAME = "HO";
    public final String HO_QUEUE = "ho_queue";

    private void intialiseHOdb(){
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(HO_QUEUE, false, false, false, null);
            // Set up a callback function for processing incoming messages
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                int msgL = message.length();
                String flag = message.substring(0,3);
                message = message.substring(3,msgL);
                System.out.println(flag);
                System.out.println("le flag est :  "+flag + " et le message est :  "+message);
                if(flag.equals("ADD") ) {
                    Product p = Product.parseObjectFromString(message);
                    System.out.println("HO Received the product:'" + p.toString() + "'");
                    ManageData.sendToDB(p, HO_DBNAME);
                }
                else if (flag.equals("DEL")){
                    String id = message;
                    ManageData.removeFromBD(id,HO_DBNAME);
                    System.out.println("HO Removed product:'" + id + "'");
                }

            };
            channel.basicConsume(HO_QUEUE, true, deliverCallback, consumerTag -> {
            });
        }catch (Exception e){
        }
    }



    public HOGUI(){
        ManageData.createDb(HO_DBNAME);
        ManageData.createProductTable(HO_DBNAME);
        intialiseHOdb();
        new HoShowProductGUI(HO_DBNAME);
    }

    public static void main(String[] args) {
        new HOGUI();
    }
}
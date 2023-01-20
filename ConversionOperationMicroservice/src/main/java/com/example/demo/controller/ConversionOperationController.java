package com.example.demo.controller;



import com.example.demo.entity.CoversionOperation;
import com.example.demo.service.ConversionOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConversionOperationController {
    @Autowired
    ConversionOperationService conversionOperationService;

    @RequestMapping(value="/operation",method = RequestMethod.POST)
    public CoversionOperation create(@RequestBody CoversionOperation x){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String today =dtf.format(now);
            Double rate =  sendPOST(x.getCurrencyFrom(),x.getCurrencyTo(), today);
            x.setConversionRate(rate);
            x.setConvertedAmount(rate*x.getInitialAmount());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conversionOperationService.create(x);
    }


    @RequestMapping(value="/operation",method = RequestMethod.GET)
    public List<CoversionOperation> read(){
        return conversionOperationService.get();
    }


    @RequestMapping(value="/operation/{id}",method = RequestMethod.PUT)
    public CoversionOperation update(@PathVariable(value="id") Long id, @RequestBody CoversionOperation op){
        return conversionOperationService.update(id,op);
    }

    @RequestMapping(value="/operation/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id){
        conversionOperationService.delete(id);
    }
    private static double sendPOST(String from, String to,String date) throws IOException {
        try {

            URL url = new URL("http://localhost:8080/api/rate");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
        //JSON INPUT
            String input = "{\"from\":\""+from+"\",\"to\":\""+to+"\", \"date\":\""+date+"\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();



            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            String outputJson ="";
            while ((output = br.readLine()) != null) {
                outputJson = output ;
            }
            conn.disconnect();
            return (Double.parseDouble(outputJson));



        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return 0;
    }

}
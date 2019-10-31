/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

// Imports the Google Cloud client library
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.io.IOException;

/**
 *
 * @author fioro
 */
public class api {

    /**
     *
     * @param texto
     * @return
     * @throws IOException
     */
    public String api(String texto) throws IOException {
    // Instantiates a client
    try (LanguageServiceClient language = LanguageServiceClient.create()) {

      // The text to analyze
      String text = texto;
      Document doc = Document.newBuilder()
          .setContent(text).setType(Type.PLAIN_TEXT).build();

      // Detects the sentiment of the text
      Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

      //System.out.printf("Text: %s%n", text);
      String sentimiento = "Valoracion: " +sentiment.getScore();
      return sentimiento;
    // Install the Java helper library from twilio.com/docs/libraries/java



    // Find your Account Sid and Auth Token at twilio.com/console
    }}
    }
  

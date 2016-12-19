package com.mikejenkins.kodiassistant.service.kodi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Mike Jenkins
 * @version 0.1.0, 12/10/2016
 * @since 0.1.0
 */

//TODO - Clean up
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRequest {

    public enum StartPoint{
        RESUME,
        START;

        public static StartPoint fromString(String value){
            for(StartPoint startPoint: StartPoint.values()){
                if(startPoint.toString().compareToIgnoreCase(value) == 0) {
                    return startPoint;
                }
            }
            return RESUME;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Request{
        public class Data{
            protected String text, type, event, team, user, channel, ts;
            protected String[] match;

            public Data() {
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getEvent() {
                return event;
            }

            public void setEvent(String event) {
                this.event = event;
            }

            public String getTeam() {
                return team;
            }

            public void setTeam(String team) {
                this.team = team;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getTs() {
                return ts;
            }

            public void setTs(String ts) {
                this.ts = ts;
            }

            public String[] getMatch() {
                return match;
            }

            public void setMatch(String[] match) {
                this.match = match;
            }
        }

        protected String source;
        protected Data data;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Result{
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Fulfillment{

            @JsonIgnoreProperties(ignoreUnknown = true)
            public class Message{
                protected String speech;
                protected int type;

                public Message() {
                }

                public String getSpeech() {
                    return speech;
                }

                public void setSpeech(String speech) {
                    this.speech = speech;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            protected String speech;
//            protected Message[] messages;

            public String getSpeech() {
                return speech;
            }

            public void setSpeech(String speech) {
                this.speech = speech;
            }

//            public Message[] getMessages() {
//                return messages;
//            }
//
//            public void setMessages(Message[] messages) {
//                this.messages = messages;
//            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Context{
            protected String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Metadata{
            protected String intentName, intentId;

            public String getIntentName() {
                return intentName;
            }

            public void setIntentName(String intentName) {
                this.intentName = intentName;
            }

            public String getIntentId() {
                return intentId;
            }

            public void setIntentId(String intentId) {
                this.intentId = intentId;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Params{
            @JsonProperty("media-type")
            protected String mediaType;
            @JsonProperty("media-title")
            protected String mediaTitle;
            @JsonProperty("media-start-point")
            protected String startPoint;
            @JsonProperty("episode-select")
            protected String episodeSelect;

            public String getMediaType() {
                return mediaType;
            }

            public void setMediaType(String mediaType) {
                this.mediaType = mediaType;
            }

            public String getMediaTitle() {
                return mediaTitle;
            }

            public void setMediaTitle(String mediaTitle) {
                this.mediaTitle = mediaTitle;
            }

            public StartPoint getStartPoint() {
                return StartPoint.fromString(startPoint);
            }

            public void setStartPoint(String startPoint) {
                this.startPoint = startPoint;
            }

            public String getEpisodeSelect() {
                return episodeSelect;
            }

            public void setEpisodeSelect(String episodeSelect) {
                this.episodeSelect = episodeSelect;
            }
        }

        protected float score;
        protected boolean actionIncomplete;
        protected String speech, source, action, resolvedQuery;
        protected Fulfillment fulfillment;
        protected Context[] contexts;
        protected Metadata metadata;
        protected Params parameters;


        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public boolean isActionIncomplete() {
            return actionIncomplete;
        }

        public void setActionIncomplete(boolean actionIncomplete) {
            this.actionIncomplete = actionIncomplete;
        }

        public String getSpeech() {
            return speech;
        }

        public void setSpeech(String speech) {
            this.speech = speech;
        }

        public String getResolvedQuery() {
            return resolvedQuery;
        }

        public void setResolvedQuery(String resolvedQuery) {
            this.resolvedQuery = resolvedQuery;
        }

        public Fulfillment getFulfillment() {
            return fulfillment;
        }

        public void setFulfillment(Fulfillment fulfillment) {
            this.fulfillment = fulfillment;
        }

        public Context[] getContexts() {
            return contexts;
        }

        public void setContexts(Context[] contexts) {
            this.contexts = contexts;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

        public Params getParameters() {
            return parameters;
        }

        public void setParameters(Params parameters) {
            this.parameters = parameters;
        }
    }

    public enum Intent{
        PLAY_MEDIA("media-select");

        private String intentName;

        Intent(String intentName){
            this.intentName = intentName;
        }

        public static Intent fromString(String name){
            for(Intent intent: Intent.values()){
                if(intent.intentName.compareTo(name) == 0)
                    return intent;
            }
            throw new EnumConstantNotPresentException(Intent.class, name);
        }
    }

    protected Result result;
    protected String id, sessionId;
    protected Date timestamp;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Intent getIntent(){
        try {
            return Intent.fromString(this.result.metadata.intentName);
        } catch (Exception e){
            return Intent.PLAY_MEDIA;
        }
    }
    public Result.Params getParams(){
        return this.result.parameters;
    }
}

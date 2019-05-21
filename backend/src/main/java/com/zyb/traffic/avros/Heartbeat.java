/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.zyb.traffic.avros;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Heartbeat extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Heartbeat\",\"namespace\":\"com.zyb.traffic.avros\",\"fields\":[{\"name\":\"tracker_version\",\"type\":\"string\",\"default\":\"-\"},{\"name\":\"profile_id\",\"type\":\"int\",\"default\":0},{\"name\":\"user_id\",\"type\":\"string\",\"default\":\"-\"},{\"name\":\"server_session_id\",\"type\":\"long\",\"default\":0},{\"name\":\"server_time\",\"type\":\"string\",\"default\":\"-\"},{\"name\":\"loading_duration\",\"type\":\"int\",\"default\":0},{\"name\":\"page_view_id\",\"type\":\"string\",\"default\":\"-\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence tracker_version;
  @Deprecated public int profile_id;
  @Deprecated public java.lang.CharSequence user_id;
  @Deprecated public long server_session_id;
  @Deprecated public java.lang.CharSequence server_time;
  @Deprecated public int loading_duration;
  @Deprecated public java.lang.CharSequence page_view_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Heartbeat() {}

  /**
   * All-args constructor.
   */
  public Heartbeat(java.lang.CharSequence tracker_version, java.lang.Integer profile_id, java.lang.CharSequence user_id, java.lang.Long server_session_id, java.lang.CharSequence server_time, java.lang.Integer loading_duration, java.lang.CharSequence page_view_id) {
    this.tracker_version = tracker_version;
    this.profile_id = profile_id;
    this.user_id = user_id;
    this.server_session_id = server_session_id;
    this.server_time = server_time;
    this.loading_duration = loading_duration;
    this.page_view_id = page_view_id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tracker_version;
    case 1: return profile_id;
    case 2: return user_id;
    case 3: return server_session_id;
    case 4: return server_time;
    case 5: return loading_duration;
    case 6: return page_view_id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tracker_version = (java.lang.CharSequence)value$; break;
    case 1: profile_id = (java.lang.Integer)value$; break;
    case 2: user_id = (java.lang.CharSequence)value$; break;
    case 3: server_session_id = (java.lang.Long)value$; break;
    case 4: server_time = (java.lang.CharSequence)value$; break;
    case 5: loading_duration = (java.lang.Integer)value$; break;
    case 6: page_view_id = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'tracker_version' field.
   */
  public java.lang.CharSequence getTrackerVersion() {
    return tracker_version;
  }

  /**
   * Sets the value of the 'tracker_version' field.
   * @param value the value to set.
   */
  public void setTrackerVersion(java.lang.CharSequence value) {
    this.tracker_version = value;
  }

  /**
   * Gets the value of the 'profile_id' field.
   */
  public java.lang.Integer getProfileId() {
    return profile_id;
  }

  /**
   * Sets the value of the 'profile_id' field.
   * @param value the value to set.
   */
  public void setProfileId(java.lang.Integer value) {
    this.profile_id = value;
  }

  /**
   * Gets the value of the 'user_id' field.
   */
  public java.lang.CharSequence getUserId() {
    return user_id;
  }

  /**
   * Sets the value of the 'user_id' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.CharSequence value) {
    this.user_id = value;
  }

  /**
   * Gets the value of the 'server_session_id' field.
   */
  public java.lang.Long getServerSessionId() {
    return server_session_id;
  }

  /**
   * Sets the value of the 'server_session_id' field.
   * @param value the value to set.
   */
  public void setServerSessionId(java.lang.Long value) {
    this.server_session_id = value;
  }

  /**
   * Gets the value of the 'server_time' field.
   */
  public java.lang.CharSequence getServerTime() {
    return server_time;
  }

  /**
   * Sets the value of the 'server_time' field.
   * @param value the value to set.
   */
  public void setServerTime(java.lang.CharSequence value) {
    this.server_time = value;
  }

  /**
   * Gets the value of the 'loading_duration' field.
   */
  public java.lang.Integer getLoadingDuration() {
    return loading_duration;
  }

  /**
   * Sets the value of the 'loading_duration' field.
   * @param value the value to set.
   */
  public void setLoadingDuration(java.lang.Integer value) {
    this.loading_duration = value;
  }

  /**
   * Gets the value of the 'page_view_id' field.
   */
  public java.lang.CharSequence getPageViewId() {
    return page_view_id;
  }

  /**
   * Sets the value of the 'page_view_id' field.
   * @param value the value to set.
   */
  public void setPageViewId(java.lang.CharSequence value) {
    this.page_view_id = value;
  }

  /** Creates a new Heartbeat RecordBuilder */
  public static com.zyb.traffic.avros.Heartbeat.Builder newBuilder() {
    return new com.zyb.traffic.avros.Heartbeat.Builder();
  }
  
  /** Creates a new Heartbeat RecordBuilder by copying an existing Builder */
  public static com.zyb.traffic.avros.Heartbeat.Builder newBuilder(com.zyb.traffic.avros.Heartbeat.Builder other) {
    return new com.zyb.traffic.avros.Heartbeat.Builder(other);
  }
  
  /** Creates a new Heartbeat RecordBuilder by copying an existing Heartbeat instance */
  public static com.zyb.traffic.avros.Heartbeat.Builder newBuilder(com.zyb.traffic.avros.Heartbeat other) {
    return new com.zyb.traffic.avros.Heartbeat.Builder(other);
  }
  
  /**
   * RecordBuilder for Heartbeat instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Heartbeat>
    implements org.apache.avro.data.RecordBuilder<Heartbeat> {

    private java.lang.CharSequence tracker_version;
    private int profile_id;
    private java.lang.CharSequence user_id;
    private long server_session_id;
    private java.lang.CharSequence server_time;
    private int loading_duration;
    private java.lang.CharSequence page_view_id;

    /** Creates a new Builder */
    private Builder() {
      super(com.zyb.traffic.avros.Heartbeat.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.zyb.traffic.avros.Heartbeat.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tracker_version)) {
        this.tracker_version = data().deepCopy(fields()[0].schema(), other.tracker_version);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.profile_id)) {
        this.profile_id = data().deepCopy(fields()[1].schema(), other.profile_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.user_id)) {
        this.user_id = data().deepCopy(fields()[2].schema(), other.user_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.server_session_id)) {
        this.server_session_id = data().deepCopy(fields()[3].schema(), other.server_session_id);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.server_time)) {
        this.server_time = data().deepCopy(fields()[4].schema(), other.server_time);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.loading_duration)) {
        this.loading_duration = data().deepCopy(fields()[5].schema(), other.loading_duration);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.page_view_id)) {
        this.page_view_id = data().deepCopy(fields()[6].schema(), other.page_view_id);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Heartbeat instance */
    private Builder(com.zyb.traffic.avros.Heartbeat other) {
            super(com.zyb.traffic.avros.Heartbeat.SCHEMA$);
      if (isValidValue(fields()[0], other.tracker_version)) {
        this.tracker_version = data().deepCopy(fields()[0].schema(), other.tracker_version);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.profile_id)) {
        this.profile_id = data().deepCopy(fields()[1].schema(), other.profile_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.user_id)) {
        this.user_id = data().deepCopy(fields()[2].schema(), other.user_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.server_session_id)) {
        this.server_session_id = data().deepCopy(fields()[3].schema(), other.server_session_id);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.server_time)) {
        this.server_time = data().deepCopy(fields()[4].schema(), other.server_time);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.loading_duration)) {
        this.loading_duration = data().deepCopy(fields()[5].schema(), other.loading_duration);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.page_view_id)) {
        this.page_view_id = data().deepCopy(fields()[6].schema(), other.page_view_id);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'tracker_version' field */
    public java.lang.CharSequence getTrackerVersion() {
      return tracker_version;
    }
    
    /** Sets the value of the 'tracker_version' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setTrackerVersion(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.tracker_version = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'tracker_version' field has been set */
    public boolean hasTrackerVersion() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'tracker_version' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearTrackerVersion() {
      tracker_version = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'profile_id' field */
    public java.lang.Integer getProfileId() {
      return profile_id;
    }
    
    /** Sets the value of the 'profile_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setProfileId(int value) {
      validate(fields()[1], value);
      this.profile_id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'profile_id' field has been set */
    public boolean hasProfileId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'profile_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearProfileId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'user_id' field */
    public java.lang.CharSequence getUserId() {
      return user_id;
    }
    
    /** Sets the value of the 'user_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setUserId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.user_id = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'user_id' field has been set */
    public boolean hasUserId() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'user_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearUserId() {
      user_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'server_session_id' field */
    public java.lang.Long getServerSessionId() {
      return server_session_id;
    }
    
    /** Sets the value of the 'server_session_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setServerSessionId(long value) {
      validate(fields()[3], value);
      this.server_session_id = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'server_session_id' field has been set */
    public boolean hasServerSessionId() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'server_session_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearServerSessionId() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'server_time' field */
    public java.lang.CharSequence getServerTime() {
      return server_time;
    }
    
    /** Sets the value of the 'server_time' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setServerTime(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.server_time = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'server_time' field has been set */
    public boolean hasServerTime() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'server_time' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearServerTime() {
      server_time = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'loading_duration' field */
    public java.lang.Integer getLoadingDuration() {
      return loading_duration;
    }
    
    /** Sets the value of the 'loading_duration' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setLoadingDuration(int value) {
      validate(fields()[5], value);
      this.loading_duration = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'loading_duration' field has been set */
    public boolean hasLoadingDuration() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'loading_duration' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearLoadingDuration() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'page_view_id' field */
    public java.lang.CharSequence getPageViewId() {
      return page_view_id;
    }
    
    /** Sets the value of the 'page_view_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder setPageViewId(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.page_view_id = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'page_view_id' field has been set */
    public boolean hasPageViewId() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'page_view_id' field */
    public com.zyb.traffic.avros.Heartbeat.Builder clearPageViewId() {
      page_view_id = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public Heartbeat build() {
      try {
        Heartbeat record = new Heartbeat();
        record.tracker_version = fieldSetFlags()[0] ? this.tracker_version : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.profile_id = fieldSetFlags()[1] ? this.profile_id : (java.lang.Integer) defaultValue(fields()[1]);
        record.user_id = fieldSetFlags()[2] ? this.user_id : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.server_session_id = fieldSetFlags()[3] ? this.server_session_id : (java.lang.Long) defaultValue(fields()[3]);
        record.server_time = fieldSetFlags()[4] ? this.server_time : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.loading_duration = fieldSetFlags()[5] ? this.loading_duration : (java.lang.Integer) defaultValue(fields()[5]);
        record.page_view_id = fieldSetFlags()[6] ? this.page_view_id : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}

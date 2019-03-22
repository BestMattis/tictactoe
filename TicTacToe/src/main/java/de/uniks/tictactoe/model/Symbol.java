package de.uniks.tictactoe.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Symbol 
{

   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Symbol setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutSymbols(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withSymbols(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_playingFieldBlock = "playingFieldBlock";

   private PlayingFieldBlock playingFieldBlock = null;

   public PlayingFieldBlock getPlayingFieldBlock()
   {
      return this.playingFieldBlock;
   }

   public Symbol setPlayingFieldBlock(PlayingFieldBlock value)
   {
      if (this.playingFieldBlock != value)
      {
         PlayingFieldBlock oldValue = this.playingFieldBlock;
         if (this.playingFieldBlock != null)
         {
            this.playingFieldBlock = null;
            oldValue.setSymbol(null);
         }
         this.playingFieldBlock = value;
         if (value != null)
         {
            value.setSymbol(this);
         }
         firePropertyChange("playingFieldBlock", oldValue, value);
      }
      return this;
   }



   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }



   public void removeYou()
   {
      this.setPlayer(null);
      this.setPlayingFieldBlock(null);

   }


}
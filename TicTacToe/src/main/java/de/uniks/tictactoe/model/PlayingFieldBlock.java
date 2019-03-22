package de.uniks.tictactoe.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class PlayingFieldBlock 
{

   public static final String PROPERTY_owned = "owned";

   private boolean owned;

   public boolean getOwned()
   {
      return owned;
   }

   public PlayingFieldBlock setOwned(boolean value)
   {
      if (value != this.owned)
      {
         boolean oldValue = this.owned;
         this.owned = value;
         firePropertyChange("owned", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_xPos = "xPos";

   private double xPos;

   public double getXPos()
   {
      return xPos;
   }

   public PlayingFieldBlock setXPos(double value)
   {
      if (value != this.xPos)
      {
         double oldValue = this.xPos;
         this.xPos = value;
         firePropertyChange("xPos", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_YPos = "YPos";

   private double YPos;

   public double getYPos()
   {
      return YPos;
   }

   public PlayingFieldBlock setYPos(double value)
   {
      if (value != this.YPos)
      {
         double oldValue = this.YPos;
         this.YPos = value;
         firePropertyChange("YPos", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public PlayingFieldBlock setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutPlayingFieldBlocks(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withPlayingFieldBlocks(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public PlayingFieldBlock setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutPlayingFieldBlocks(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withPlayingFieldBlocks(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



public static final java.util.ArrayList<PlayingFieldBlock> EMPTY_neightbors = new java.util.ArrayList<PlayingFieldBlock>()
   { @Override public boolean add(PlayingFieldBlock value){ throw new UnsupportedOperationException("No direct add! Use xy.withNeightbors(obj)"); }};


public static final String PROPERTY_neightbors = "neightbors";

private java.util.ArrayList<PlayingFieldBlock> neightbors = null;

public java.util.ArrayList<PlayingFieldBlock> getNeightbors()
   {
      if (this.neightbors == null)
      {
         return EMPTY_neightbors;
      }

      return this.neightbors;
   }

public PlayingFieldBlock withNeightbors(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withNeightbors(i);
            }
         }
         else if (item instanceof PlayingFieldBlock)
         {
            if (this.neightbors == null)
            {
               this.neightbors = new java.util.ArrayList<PlayingFieldBlock>();
            }
            if ( ! this.neightbors.contains(item))
            {
               this.neightbors.add((PlayingFieldBlock)item);
               ((PlayingFieldBlock)item).withNeightbors(this);
               firePropertyChange("neightbors", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }


public PlayingFieldBlock withoutNeightbors(Object... value)
   {
      if (this.neightbors == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutNeightbors(i);
            }
         }
         else if (item instanceof PlayingFieldBlock)
         {
            if (this.neightbors.contains(item))
            {
               this.neightbors.remove((PlayingFieldBlock)item);
               ((PlayingFieldBlock)item).withoutNeightbors(this);
               firePropertyChange("neightbors", item, null);
            }
         }
      }
      return this;
   }


   public static final String PROPERTY_symbol = "symbol";

   private Symbol symbol = null;

   public Symbol getSymbol()
   {
      return this.symbol;
   }

   public PlayingFieldBlock setSymbol(Symbol value)
   {
      if (this.symbol != value)
      {
         Symbol oldValue = this.symbol;
         if (this.symbol != null)
         {
            this.symbol = null;
            oldValue.setPlayingFieldBlock(null);
         }
         this.symbol = value;
         if (value != null)
         {
            value.setPlayingFieldBlock(this);
         }
         firePropertyChange("symbol", oldValue, value);
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
      this.setGame(null);
      this.setPlayer(null);
      this.setSymbol(null);

      this.withoutNeightbors(this.getNeightbors().clone());


      this.withoutNeightbors(this.getNeightbors().clone());


   }


}
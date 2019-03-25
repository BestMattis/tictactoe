package de.uniks.tictactoe.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Player  
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Player setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public Player setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutPlayers(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withPlayers(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_gameWon = "gameWon";

   private Game gameWon = null;

   public Game getGameWon()
   {
      return this.gameWon;
   }

   public Player setGameWon(Game value)
   {
      if (this.gameWon != value)
      {
         Game oldValue = this.gameWon;
         if (this.gameWon != null)
         {
            this.gameWon = null;
            oldValue.setWinner(null);
         }
         this.gameWon = value;
         if (value != null)
         {
            value.setWinner(this);
         }
         firePropertyChange("gameWon", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_currentGame = "currentGame";

   private Game currentGame = null;

   public Game getCurrentGame()
   {
      return this.currentGame;
   }

   public Player setCurrentGame(Game value)
   {
      if (this.currentGame != value)
      {
         Game oldValue = this.currentGame;
         if (this.currentGame != null)
         {
            this.currentGame = null;
            oldValue.setCurrentPlayer(null);
         }
         this.currentGame = value;
         if (value != null)
         {
            value.setCurrentPlayer(this);
         }
         firePropertyChange("currentGame", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Symbol> EMPTY_symbols = new java.util.ArrayList<Symbol>()
   { @Override public boolean add(Symbol value){ throw new UnsupportedOperationException("No direct add! Use xy.withSymbols(obj)"); }};


   public static final String PROPERTY_symbols = "symbols";

   private java.util.ArrayList<Symbol> symbols = null;

   public java.util.ArrayList<Symbol> getSymbols()
   {
      if (this.symbols == null)
      {
         return EMPTY_symbols;
      }

      return this.symbols;
   }

   public Player withSymbols(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withSymbols(i);
            }
         }
         else if (item instanceof Symbol)
         {
            if (this.symbols == null)
            {
               this.symbols = new java.util.ArrayList<Symbol>();
            }
            if ( ! this.symbols.contains(item))
            {
               this.symbols.add((Symbol)item);
               ((Symbol)item).setPlayer(this);
               firePropertyChange("symbols", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutSymbols(Object... value)
   {
      if (this.symbols == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutSymbols(i);
            }
         }
         else if (item instanceof Symbol)
         {
            if (this.symbols.contains(item))
            {
               this.symbols.remove((Symbol)item);
               ((Symbol)item).setPlayer(null);
               firePropertyChange("symbols", item, null);
            }
         }
      }
      return this;
   }


   public static final java.util.ArrayList<PlayingFieldBlock> EMPTY_playingFieldBlocks = new java.util.ArrayList<PlayingFieldBlock>()
   { @Override public boolean add(PlayingFieldBlock value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlayingFieldBlocks(obj)"); }};


   public static final String PROPERTY_playingFieldBlocks = "playingFieldBlocks";

   private java.util.ArrayList<PlayingFieldBlock> playingFieldBlocks = null;

   public java.util.ArrayList<PlayingFieldBlock> getPlayingFieldBlocks()
   {
      if (this.playingFieldBlocks == null)
      {
         return EMPTY_playingFieldBlocks;
      }

      return this.playingFieldBlocks;
   }

   public Player withPlayingFieldBlocks(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlayingFieldBlocks(i);
            }
         }
         else if (item instanceof PlayingFieldBlock)
         {
            if (this.playingFieldBlocks == null)
            {
               this.playingFieldBlocks = new java.util.ArrayList<PlayingFieldBlock>();
            }
            if ( ! this.playingFieldBlocks.contains(item))
            {
               this.playingFieldBlocks.add((PlayingFieldBlock)item);
               ((PlayingFieldBlock)item).setPlayer(this);
               firePropertyChange("playingFieldBlocks", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutPlayingFieldBlocks(Object... value)
   {
      if (this.playingFieldBlocks == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlayingFieldBlocks(i);
            }
         }
         else if (item instanceof PlayingFieldBlock)
         {
            if (this.playingFieldBlocks.contains(item))
            {
               this.playingFieldBlocks.remove((PlayingFieldBlock)item);
               ((PlayingFieldBlock)item).setPlayer(null);
               firePropertyChange("playingFieldBlocks", item, null);
            }
         }
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
      this.setGameWon(null);
      this.setCurrentGame(null);

      this.withoutSymbols(this.getSymbols().clone());


      this.withoutPlayingFieldBlocks(this.getPlayingFieldBlocks().clone());


   }


   public static final String PROPERTY_symbol = "symbol";

   private String symbol;

   public String getSymbol()
   {
      return symbol;
   }

   public Player setSymbol(String value)
   {
      if (value == null ? this.symbol != null : ! value.equals(this.symbol))
      {
         String oldValue = this.symbol;
         this.symbol = value;
         firePropertyChange("symbol", oldValue, value);
      }
      return this;
   }


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getName());
      result.append(" ").append(this.getSymbol());


      return result.substring(1);
   }

}
package de.htwg_konstanz.ebus.framework.wholesaler.vo.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public abstract class _BaseRootVOA
{
   protected static SessionFactory sessionFactory = null;
   protected final static ThreadLocal<Session> currentSession = new ThreadLocal<Session>();
   
   
   protected _BaseRootVOA()
   {
   }

   /**
    * Return a new Session object that must be closed when the work has been
    * completed.
    * 
    * @return the active Session
    */
   public Session getSession()
   {
      Session s = getSession(getConfigurationFileName());      
      Transaction t = s.getTransaction();
      
      if(t != null && t.isActive())
         return s;

      try
      {
         t = s.beginTransaction();
      } 
      catch (HibernateException e1)
      {
         e1.printStackTrace();
      }
      
      return s;
   }

   /**
    * Return a new Session object that must be closed when the work has been
    * completed.
    * 
    * @param configFile
    *           the config file must match the meta attribute "config-file" in
    *           the hibernate mapping file
    * @return the active Session
    */
   protected Session getSession(String configFile)
   {
      if(null != currentSession.get() && currentSession.get().isOpen())
      {
         return currentSession.get();
      }
      else if(null != sessionFactory)
      {
         Session s = currentSession.get();
         if(null == s || !s.isOpen())
         {
            s = sessionFactory.openSession();
            currentSession.set(s);
         }
         return s;
      } 
      else
      {
         Session s = currentSession.get();
         if (null == s || !s.isOpen())
         {
            s = getSessionFactory().openSession();
            currentSession.set(s);
         }
         return s;
      }
   }

   /**
    * Configure the session factory by reading hibernate config file
    */
   private static void initialize()
   {
      initialize((String) null);
   }

   /**
    * Configure the session factory by reading hibernate config file
    * 
    * @param configFileName
    *           the name of the configuration file
    */
   private static void initialize(String configFileName)
   {
      initialize(configFileName, getNewConfiguration(null));
   }

   private static void initialize(String configFileName, Configuration configuration)
   {
      if(null == configFileName)
         configuration.configure();
      else
         configuration.configure(configFileName);

      sessionFactory = configuration.buildSessionFactory();
   }

   /**
    * Return the SessionFactory that is to be used by these DAOs. Change this
    * and implement your own strategy if you, for example, want to pull the
    * SessionFactory from the JNDI tree.
    */
   public SessionFactory getSessionFactory()
   {
      if(null == sessionFactory)
         initialize();
         
      return sessionFactory;
   }

   /**
    * Commit the given transaction
    */
   public void commitTransaction()
   {
      Session s = getSession();
      s.getTransaction().commit();
      s.close();
   }

   /**
    * Rollback the given transaction
    */
   public void rollbackTransaction()
   {
      Session s = getSession();
      s.getTransaction().rollback();
      s.close();
   }

   /**
    * Return a new Configuration to use. This is not a mistake and is meant to
    * be overridden in the RootDAO if you want to do something different. The
    * file name is passed in so you have that to access. The config file is read
    * in the initialize method.
    */
   public static Configuration getNewConfiguration(String configFileName)
   {
      return new Configuration();
   }

   /**
    * Return the name of the configuration file to be used with this DAO or null
    * if default
    */
   public String getConfigurationFileName()
   {
      return null;
   }

   /**
    * Return the specific Object class that will be used for class-specific
    * implementation of this DAO.
    * 
    * @return the reference Class
    */
   @SuppressWarnings("unchecked")
   protected abstract Class getReferenceClass();

   /**
    * Used by the base DAO classes but here for your modification Get object
    * matching the given key and return it.
    */
   @SuppressWarnings("unchecked")
   protected Object get(Class refClass, Serializable key)
   {
      return get(refClass, key, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Get object
    * matching the given key and return it.
    */
   @SuppressWarnings("unchecked")
   protected Object get(Class refClass, Serializable key, Session s)
   {
      return s.get(refClass, key);
   }

   /**
    * Used by the base DAO classes but here for your modification Load object
    * matching the given key and return it.
    */
   @SuppressWarnings("unchecked")
   protected Object load(Class refClass, Serializable key)
   {
      return load(refClass, key, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Load object
    * matching the given key and return it.
    */
   @SuppressWarnings("unchecked")
   protected Object load(Class refClass, Serializable key, Session s)
   {
      return s.load(refClass, key);
   }

   /**
    * Return all objects related to the implementation of this DAO with no
    * filter.
    */
   @SuppressWarnings("unchecked")
   public java.util.List findAll()
   {
      return findAll(getSession());
   }

   /**
    * Return all objects related to the implementation of this DAO with no
    * filter. Use the session given.
    * 
    * @param s
    *           the Session
    */
   @SuppressWarnings("unchecked")
   public java.util.List findAll(Session s)
   {
      return findAll(s, getDefaultOrder());
   }

   /**
    * Return all objects related to the implementation of this DAO with no
    * filter.
    */
   @SuppressWarnings("unchecked")
   public java.util.List findAll(Order defaultOrder)
   {
      return findAll(getSession(), defaultOrder);
   }

   /**
    * Return all objects related to the implementation of this DAO with no
    * filter. Use the session given.
    * 
    * @param s
    *           the Session
    */
   @SuppressWarnings("unchecked")
   public java.util.List findAll(Session s, Order defaultOrder)
   {
      Criteria crit = s.createCriteria(getReferenceClass());
      if (null != defaultOrder)
         crit.addOrder(defaultOrder);
      return crit.list();
   }

   /**
    * Return all objects related to the implementation of this DAO with a
    * filter. Use the session given.
    * 
    * @param propName
    *           the name of the property to use for filtering
    * @param filter
    *           the value of the filter
    */
   protected Criteria findFiltered(String propName, Object filter)
   {
      return findFiltered(propName, filter, getDefaultOrder());
   }

   /**
    * Return all objects related to the implementation of this DAO with a
    * filter. Use the session given.
    * 
    * @param propName
    *           the name of the property to use for filtering
    * @param filter
    *           the value of the filter
    * @param orderProperty
    *           the name of the property used for ordering
    */
   protected Criteria findFiltered(String propName, Object filter, Order order)
   {
      return findFiltered(getSession(), propName, filter, order);
   }

   /**
    * Return all objects related to the implementation of this DAO with a
    * filter. Use the session given.
    * 
    * @param s
    *           the Session
    * @param propName
    *           the name of the property to use for filtering
    * @param filter
    *           the value of the filter
    * @param orderProperty
    *           the name of the property used for ordering
    */
   protected Criteria findFiltered(Session s, String propName, Object filter,
         Order order)
   {
      Criteria crit = s.createCriteria(getReferenceClass());
      crit.add(Expression.eq(propName, filter));
      if (null != order)
         crit.addOrder(order);
      return crit;
   }

/**
 * Return all objects related to the implementation of this DAO with a
 * filter. Use the session given.
 * 
 * @param propName
 *           the name of the property to use for filtering
 * @param filter
 *           the value of the filter
 */
protected Criteria findFilteredLike(String propName, Object filter)
{
   return findFilteredLike(propName, filter, getDefaultOrder());
}

/**
 * Return all objects related to the implementation of this DAO with a
 * filter. Use the session given.
 * 
 * @param propName
 *           the name of the property to use for filtering
 * @param filter
 *           the value of the filter
 * @param orderProperty
 *           the name of the property used for ordering
 */
protected Criteria findFilteredLike(String propName, Object filter, Order order)
{
   return findFilteredLike(getSession(), propName, filter, order);
}

/**
 * Return all objects related to the implementation of this DAO with a
 * filter. Use the session given.
 * 
 * @param s
 *           the Session
 * @param propName
 *           the name of the property to use for filtering
 * @param filter
 *           the value of the filter
 * @param orderProperty
 *           the name of the property used for ordering
 */
protected Criteria findFilteredLike(Session s, String propName, Object filter, Order order)
{
   Criteria crit = s.createCriteria(getReferenceClass());
   crit.add(Expression.like(propName, filter));
   if (null != order)
      crit.addOrder(order);
   return crit;
}

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file.
    * 
    * @param name
    *           the name of a query defined externally
    * @return Query
    */
   protected Query getNamedQuery(String name)
   {
      return getNamedQuery(name, getSession());
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the session given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param s
    *           the Session
    * @return Query
    */
   protected Query getNamedQuery(String name, Session s)
   {
      Query q = s.getNamedQuery(name);
      return q;
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file.
    * 
    * @param name
    *           the name of a query defined externally
    * @param param
    *           the first parameter to set
    * @return Query
    */
   protected Query getNamedQuery(String name, Serializable param)
   {
      return getNamedQuery(name, param, getSession());
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the session given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param param
    *           the first parameter to set
    * @param s
    *           the Session
    * @return Query
    */
   protected Query getNamedQuery(String name, Serializable param, Session s)
   {
      Query q = s.getNamedQuery(name);
      q.setParameter(0, param);
      return q;
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param params
    *           the parameter array
    * @return Query
    */
   protected Query getNamedQuery(String name, Serializable[] params)
   {
      return getNamedQuery(name, params, getSession());
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given and the Session given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param params
    *           the parameter array
    * @s the Session
    * @return Query
    */
   protected Query getNamedQuery(String name, Serializable[] params, Session s)
   {
      Query q = s.getNamedQuery(name);
      if (null != params)
      {
         for (int i = 0; i < params.length; i++)
         {
            q.setParameter(i, params[i]);
         }
      }
      return q;
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param params
    *           the parameter Map
    * @return Query
    */
   @SuppressWarnings("unchecked")
   protected Query getNamedQuery(String name, Map params)
   {
      return getNamedQuery(name, params, getSession());
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given and the Session given.
    * 
    * @param name
    *           the name of a query defined externally
    * @param params
    *           the parameter Map
    * @s the Session
    * @return Query
    */
   @SuppressWarnings("unchecked")
   protected Query getNamedQuery(String name, Map params, Session s)
   {
      Query q = s.getNamedQuery(name);
      if (null != params)
      {
         for (Iterator i = params.entrySet().iterator(); i.hasNext();)
         {
            Map.Entry entry = (Map.Entry) i.next();
            q.setParameter((String) entry.getKey(), entry.getValue());
         }
      }
      return q;
   }

   /**
    * Execute a query.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @return a distinct list of instances (or arrays of instances)
    */
   public Query getQuery(String queryStr)
   {
      return getQuery(queryStr, getSession());
   }

   /**
    * Execute a query but use the session given instead of creating a new one.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @s the Session to use
    */
   public Query getQuery(String queryStr, Session s)
   {
      return s.createQuery(queryStr);
   }

   /**
    * Execute a query.
    * 
    * @param query
    *           a query expressed in Hibernate's query language
    * @param queryStr
    *           the name of a query defined externally
    * @param param
    *           the first parameter to set
    * @return Query
    */
   protected Query getQuery(String queryStr, Serializable param)
   {
      return getQuery(queryStr, param, getSession());
   }

   /**
    * Execute a query but use the session given instead of creating a new one.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @param param
    *           the first parameter to set
    * @s the Session to use
    * @return Query
    */
   protected Query getQuery(String queryStr, Serializable param, Session s)
   {
      Query q = getQuery(queryStr, s);
      q.setParameter(0, param);
      return q;
   }

   /**
    * Execute a query.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @param params
    *           the parameter array
    * @return Query
    */
   protected Query getQuery(String queryStr, Serializable[] params)
   {
      return getQuery(queryStr, params, getSession());
   }

   /**
    * Execute a query but use the session given instead of creating a new one.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @param params
    *           the parameter array
    * @s the Session
    * @return Query
    */
   protected Query getQuery(String queryStr, Serializable[] params, Session s)
   {
      Query q = getQuery(queryStr, s);
      if (null != params)
      {
         for (int i = 0; i < params.length; i++)
         {
            q.setParameter(i, params[i]);
         }
      }
      return q;
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @param params
    *           the parameter Map
    * @return Query
    */
   @SuppressWarnings("unchecked")
   protected Query getQuery(String queryStr, Map params)
   {
      return getQuery(queryStr, params, getSession());
   }

   /**
    * Obtain an instance of Query for a named query string defined in the
    * mapping file. Use the parameters given and the Session given.
    * 
    * @param queryStr
    *           a query expressed in Hibernate's query language
    * @param params
    *           the parameter Map
    * @s the Session
    * @return Query
    */
   @SuppressWarnings("unchecked")
   protected Query getQuery(String queryStr, Map params, Session s)
   {
      Query q = getQuery(queryStr, s);
      if (null != params)
      {
         for (Iterator i = params.entrySet().iterator(); i.hasNext();)
         {
            Map.Entry entry = (Map.Entry) i.next();
            q.setParameter((String) entry.getKey(), entry.getValue());
         }
      }
      return q;
   }

   protected Order getDefaultOrder()
   {
      return null;
   }

   /**
    * Used by the base DAO classes but here for your modification Persist the
    * given transient instance, first assigning a generated identifier. (Or
    * using the current value of the identifier property if the assigned
    * generator is used.)
    */
   protected Serializable save(final Object obj)
   {
      return save(obj, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Persist the
    * given transient instance, first assigning a generated identifier. (Or
    * using the current value of the identifier property if the assigned
    * generator is used.)
    */
   protected Serializable save(Object obj, Session s)
   {
      return s.save(obj);
   }

   /**
    * Used by the base DAO classes but here for your modification Either save()
    * or update() the given instance, depending upon the value of its identifier
    * property.
    */
   protected void saveOrUpdate(final Object obj)
   {
      saveOrUpdate(obj, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Either save()
    * or update() the given instance, depending upon the value of its identifier
    * property.
    */
   protected void saveOrUpdate(Object obj, Session s)
   {
      s.saveOrUpdate(obj);
   }

   /**
    * Used by the base DAO classes but here for your modification Update the
    * persistent state associated with the given identifier. An exception is
    * thrown if there is a persistent instance with the same identifier in the
    * current session.
    * 
    * @param obj
    *           a transient instance containing updated state
    */
   protected void update(final Object obj)
   {
      update(obj, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Update the
    * persistent state associated with the given identifier. An exception is
    * thrown if there is a persistent instance with the same identifier in the
    * current session.
    * 
    * @param obj
    *           a transient instance containing updated state
    * @param s
    *           the Session
    */
   protected void update(Object obj, Session s)
   {
      s.update(obj);
   }

   /**
    * Delete all objects returned by the query
    */
   protected int delete(final Query query)
   {
      return new Integer(delete((Query) query, getSession())).intValue();
   }

   /**
    * Delete all objects returned by the query
    */
   @SuppressWarnings("unchecked")
   protected int delete(Query query, Session s)
   {
      List list = query.list();
      for (Iterator i = list.iterator(); i.hasNext();)
      {
         delete(i.next(), s);
      }
      return list.size();
   }

   /**
    * Used by the base DAO classes but here for your modification Remove a
    * persistent instance from the datastore. The argument may be an instance
    * associated with the receiving Session or a transient instance with an
    * identifier associated with existing persistent state.
    */
   protected void delete(final Object obj)
   {
      delete(obj, getSession());
   }

   /**
    * Used by the base DAO classes but here for your modification Remove a
    * persistent instance from the datastore. The argument may be an instance
    * associated with the receiving Session or a transient instance with an
    * identifier associated with existing persistent state.
    */
   protected void delete(Object obj, Session s)
   {
      s.delete(obj);
   }

   /**
    * Used by the base DAO classes but here for your modification Re-read the
    * state of the given instance from the underlying database. It is
    * inadvisable to use this to implement long-running sessions that span many
    * business tasks. This method is, however, useful in certain special
    * circumstances.
    */
   protected void refresh(Object obj, Session s)
   {
      s.refresh(obj);
   }

   protected void throwException(Throwable t)
   {
      if (t instanceof HibernateException)
         throw (HibernateException) t;
      else if (t instanceof RuntimeException)
         throw (RuntimeException) t;
      else
         throw new HibernateException(t);
   }
}
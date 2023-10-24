using CEDBMS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace CEDBMS.Controllers
{
    public class ContactsController : ApiController
    {
        
        public HttpResponseMessage Get()
        {
            List<contactu> details = new List<contactu>();
            using (shikhshabharatEntities dbContext = new shikhshabharatEntities())
            {
                details = dbContext.contactus.ToList();
                if (details.Count == 0)
                {
                    return Request.CreateResponse(HttpStatusCode.InternalServerError, "Please try again later ");
                }
                return Request.CreateResponse(HttpStatusCode.OK, details);
            }
        } 

        public HttpResponseMessage Post(contactu details) 
        {
            using(shikhshabharatEntities dbContext=new shikhshabharatEntities())
            {
                if(details != null)
                {
                    dbContext.contactus.Add(details);
                    dbContext.SaveChanges();
                    return Request.CreateResponse(HttpStatusCode.OK, details);
                }
                else
                {
                    return Request.CreateResponse(HttpStatusCode.BadRequest, "Please provide required information");
                }
            }    
        }
    }
}

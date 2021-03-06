﻿using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Xml;
using csharpBaseline.CompanyModel;
using NUnit.Framework;

namespace csharpBaseline.Tests
{
    [TestFixture]
    public class SerializationTests
    {
        private static Company Company
        {
            get
            {
                return CompanyRepository.CreateInMemoryModel();
            }
        }

        [Test]
        public void EqualsTest()
        {
            var c1 = Company;
            var c2 = Company;
            Assert.AreEqual(true, c1.Equals(c2));
        }

        [Test]
        public void SerializationTest()
        {
            var c = Company;
            var xmlizedString = SerializationHelper.SerializeObject(c, typeof (Company));

            //example of saving serialized object into a file
            using (var fs = new FileStream("company.xml", FileMode.Create, FileAccess.ReadWrite))
            {
                using (var tw = new XmlTextWriter(fs, Encoding.UTF8))
                {
                    tw.WriteString(xmlizedString);
                }
            }

            var reconstructedCompany = SerializationHelper.DeserializeObject<Company>(xmlizedString);
            Assert.AreEqual(true, c.Equals(reconstructedCompany));

        }
    }
}

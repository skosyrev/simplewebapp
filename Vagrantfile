# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SHELL
sudo yum install -y mysql-server wget
sudo service mysqld start

mysql -u root -e "CREATE DATABASE IF NOT EXISTS sonar;"
mysql -u root -e "GRANT USAGE ON *.* TO 'sonar'@'%' IDENTIFIED BY 'sonar';"
mysql -u root -e "GRANT USAGE ON *.* TO 'sonar'@'localhost' IDENTIFIED BY 'sonar';"
mysql -u root -e "GRANT ALL PRIVILEGES ON sonar.* TO 'sonar'@'%'"
mysql -u root -e "FLUSH PRIVILEGES"

sudo yum install -y java-1.7.0-openjdk

curl -L -O --retry 5 https://sonarsource.bintray.com/Distribution/sonarqube/sonarqube-5.1.2.zip
unzip sonarqube-5.1.2.zip

sed -i 's/^#sonar.jdbc.username=sonar/sonar.jdbc.username=sonar/g' ./sonarqube-5.1.2/conf/sonar.properties
sed -i 's/^#sonar.jdbc.password=sonar/sonar.jdbc.password=sonar/g' ./sonarqube-5.1.2/conf/sonar.properties
sed -i '/3306/s/^#//g' sonarqube-5.1.2/conf/sonar.properties
sed -i 's/^#sonar.web.host=0.0.0.0/sonar.web.host=0.0.0.0/g' ./sonarqube-5.1.2/conf/sonar.properties
sed -i 's/^#sonar.web.context=/sonar.web.context=/g' ./sonarqube-5.1.2/conf/sonar.properties
sed -i 's/^#sonar.web.port=9000/sonar.web.port=9000/g' ./sonarqube-5.1.2/conf/sonar.properties

rm -f ./sonarqube-5.1.2/extensions/plugins/sonar-java-plugin-3.0.jar
curl --retry 5 -L -o ./sonarqube-5.1.2/extensions/plugins/sonar-java-plugin-3.5.jar https://sonarsource.bintray.com/Distribution/sonar-java-plugin/sonar-java-plugin-3.5.jar
curl --retry 5 -L -o ./sonarqube-5.1.2/extensions/plugins/sonar-pmd-plugin-2.4.1.jar http://downloads.sonarsource.com/plugins/org/codehaus/sonar-plugins/java/sonar-pmd-plugin/2.4.1/sonar-pmd-plugin-2.4.1.jar
curl --retry 5 -L -o ./sonarqube-5.1.2/extensions/plugins/sonar-findbugs-plugin-3.3.jar https://sonarsource.bintray.com/Distribution/sonar-findbugs-plugin/sonar-findbugs-plugin-3.3.jar
curl --retry 5 -L -o ./sonarqube-5.1.2/extensions/plugins/sonar-checkstyle-plugin-2.3.jar http://downloads.sonarsource.com/plugins/org/codehaus/sonar-plugins/java/sonar-checkstyle-plugin/2.3/sonar-checkstyle-plugin-2.3.jar

./sonarqube-5.1.2/bin/linux-x86-64/sonar.sh start
SHELL

Vagrant.configure(2) do |config|

  config.vm.box = "centos-6.5"
  config.vm.box_url = "https://github.com/2creatives/vagrant-centos/releases/download/v6.5.3/centos65-x86_64-20140116.box"

  config.vm.network "forwarded_port", guest: 9000, host: 9000
  config.vm.network "forwarded_port", guest: 3306, host: 3306

  config.vm.provision "shell", inline: $script
end

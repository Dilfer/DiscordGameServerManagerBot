resource aws_instance valheim_server {
  ami = "ami-043e33039f1a50a56"
  instance_type = "m5.large"
  key_name = aws_key_pair.personal.id
  tags = {
    DiscordGuild = lower("DaByz")
    Game = lower("Valheim")
    Name = "DaByz-Valheim"
  }
  vpc_security_group_ids = [aws_security_group.valheim_server.id]
  disable_api_termination = true
  root_block_device {
    volume_size = 10
  }
}

resource aws_security_group valheim_server {
  name        = "Valheim Server"
  description = "Necessary traffic rules to host a Valheim server."
}

resource aws_security_group_rule valheim_tcp {
  from_port = 2456
  protocol = "TCP"
  security_group_id = aws_security_group.valheim_server.id
  to_port = 2458
  type = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource aws_security_group_rule valheim_udp {
  from_port = 2456
  protocol = "UDP"
  security_group_id = aws_security_group.valheim_server.id
  to_port = 2458
  type = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource aws_security_group_rule valheim_ssha {
  from_port = 22
  protocol = "TCP"
  security_group_id = aws_security_group.valheim_server.id
  to_port = 22
  type = "ingress"
  cidr_blocks = ["156.57.64.160/32"]
}
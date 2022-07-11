import icon from '../../assets/images/notification-icon.svg';

import './styles.css';

const NotificationButton: React.FC = () => {
  return (
    <div className='dsmeta-red-btn'>
      <img src={icon} alt='Notificar' />
    </div>
  );
};

export { NotificationButton };
